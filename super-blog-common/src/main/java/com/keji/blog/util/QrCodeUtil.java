package com.keji.blog.util;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Hashtable;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.keji.blog.exception.BlogException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wb-ny291824
 * @version $Id: QrCodeUtil.java, v 0.1 2017-12-15 17:46 wb-ny291824 Exp $$
 */
public class QrCodeUtil {

    private static Logger logger = LoggerFactory.getLogger(QrCodeUtil.class);

    /**
     * 二维码的编码格式
     */
    private static final String CHARSET = "utf-8";
    /**
     *
     */
    private static final String FORMAT_NAME = "JPG";

    /**
     * 二维码尺寸
     */
    private static int qrCodeSize;

    /**
     * 生成原始的二维码图片
     *
     * @param content    二维码包含的内容
     * @param qrCodeSize 二维码尺寸,单位px
     * @return
     * @throws Exception
     */
    public static BufferedImage createQrCode(String content, int qrCodeSize) throws Exception {

        //设置二维码的参数
        Hashtable<EncodeHintType, Object> hints = new Hashtable<>(3);
        // 设置QR二维码的纠错级别（H为最高级别）具体级别信息
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        //设置二维码的编码格式
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        //设置二维码的边界
        hints.put(EncodeHintType.MARGIN, 1);

        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, qrCodeSize, qrCodeSize,
                hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }

        return image;
    }

    /**
     * 生成带logo的二维码
     *
     * @param content      二维码包含的内容
     * @param qrCodeSize   二维码尺寸,单位px
     * @param logo         logo文件
     * @param logoWidth    LOGO宽度
     * @param logoHeight   lOGO高度
     * @param needCompress 是否压缩logo,推荐为true
     * @return
     * @throws Exception
     */
    public static BufferedImage createQrCodeWithLogo(String content, int qrCodeSize, File logo, int logoWidth,
                                                     int logoHeight, boolean needCompress) throws Exception {

        BufferedImage image = createQrCode(content, qrCodeSize);
        if (null == logo) {
            logger.warn("logo文件为空");
            return image;
        }
        QrCodeUtil.qrCodeSize = qrCodeSize;
        // 插入图片
        QrCodeUtil.insertLogo(image, logo, logoWidth, logoHeight, needCompress);
        return image;
    }

    /**
     * 插入二维码
     *
     * @param source       二维码对象
     * @param logo         logo文件
     * @param needCompress 是否需要压缩logo
     * @throws Exception
     */
    public static void insertLogo(BufferedImage source, File logo, int logoWidth, int logoHeight, boolean needCompress)
            throws Exception {
        if (!logo.exists()) {
            logger.warn("logo图片不存在");
            return;
        }
        Image src = ImageIO.read(logo);
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        if (needCompress) {
            // 压缩LOGO
            if (width > logoWidth) {
                width = logoWidth;
            }
            if (height > logoHeight) {
                height = logoHeight;
            }
            Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            // 绘制缩小后的图
            g.drawImage(image, 0, 0, null);
            g.dispose();
            src = image;
        }
        // 插入LOGO
        Graphics2D graph = source.createGraphics();
        int x = (qrCodeSize - width) / 2;
        int y = (qrCodeSize - height) / 2;
        graph.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }

    /**
     * 在图片的顶部或者底部添加字符串
     *
     * @param source       图片来源
     * @param topString    顶部的字符串
     * @param bottomString 底部字符串
     * @param width        新图片的宽度
     * @param height       新图片的宽度
     * @return 新生成的图片
     */
    public static BufferedImage drawStringToImage(BufferedImage source, String topString, String bottomString,
                                                  int width, int height) {
        //新的图片，把带logo的二维码下面加上文字
        BufferedImage outImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D outg = outImage.createGraphics();
        //设置画笔颜色并填充背景颜色
        outg.setColor(Color.WHITE);
        outg.fillRect(0, 0, width, height);
        //画二维码到新的面板
        outg.drawImage(source, (width - source.getWidth()) / 2, (width - source.getHeight()) / 2, source.getWidth(),
                source.getHeight(), null);

        //字体、字型、字号
        outg.setColor(Color.BLACK);
        outg.setFont(new Font("宋体", Font.BOLD, 30));
        if (StringUtils.isNotEmpty(topString)){
            int topStringWidth = outg.getFontMetrics().stringWidth(topString);
            outg.drawString(bottomString, (width - topStringWidth) / 2, height - (height - source.getHeight()) / 4);
        }
        if (StringUtils.isNotEmpty(bottomString)) {
            int bottomStringWidth = outg.getFontMetrics().stringWidth(bottomString);
            outg.drawString(topString, (width - bottomStringWidth) / 2, (height - source.getHeight()) / 4);

        }

        outg.dispose();
        outImage.flush();
        return outImage;
    }

    /**
     * 将图片保存到磁盘
     *
     * @param image     原图片
     * @param savePath  图片保存路径
     * @param imageName 图片名称,可为空，为空随机名字
     */
    public static void saveImageToDist(BufferedImage image, String savePath, String imageName) throws Exception {

        File file = new File(savePath);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }

        if (StringUtils.isEmpty(imageName)) {
            imageName = new Random().nextInt(99999999) + ".jpg";
        }
        ImageIO.write(image, FORMAT_NAME, new File(savePath + "/" + imageName));
    }

    /**
     * 下载图片
     *
     * @param image    图片
     * @param response
     * @param fileName 图片名称
     * @throws Exception
     */
    public static void download(BufferedImage image, HttpServletResponse response, String fileName) throws Exception {
        InputStream fis = null;
        OutputStream toClient = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "JPG", os);
            InputStream is = new ByteArrayInputStream(os.toByteArray());
            fis = new BufferedInputStream(is);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
           toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (Exception e) {
            throw new BlogException("下载文件是发生异常");
        }finally {
            if (null != fis) {
                fis.close();
            }
            if (null != toClient) {
                toClient.close();
            }
        }
    }

}
