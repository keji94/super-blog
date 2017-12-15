package com.keji.blog.util;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wb-ny291824
 * @version $Id: AminQrCode.java, v 0.1 2017-12-15 17:46 wb-ny291824 Exp $$
 */
public class AminQrCode {

    private static Logger logger = LoggerFactory.getLogger(AminQrCode.class);

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
     * LOGO宽度
     */
    private static int logoWidth;
    /**
     * LOGO高度
     */
    private static int logoHeight;

    /**
     * 生成原始的二维码图片
     *
     * @param content 二维码包含的内容
     * @return
     * @throws Exception
     */
    private static BufferedImage createQrCode(String content) throws Exception {

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
     * @param content 二维码包含的内容
     * @param logoPath logo图片的地址
     * @param needCompress 是否压缩logo,推荐为true
     * @return
     * @throws Exception
     */
    private static BufferedImage createQrCodeWithLogo(String content, String logoPath, boolean needCompress)
            throws Exception {

        BufferedImage image = createQrCode(content);
        if (null == logoPath || "".equals(logoPath)) {
            logger.warn("找不到logo图片的地址!");
            return image;
        }
        // 插入图片
        AminQrCode.insertLogo(image, logoPath, needCompress);
        return image;
    }

    /**
     * 插入二维码
     *
     * @param source       二维码对象
     * @param logoPath     logo的地址
     * @param needCompress 是否需要压缩logo
     * @throws Exception
     */
    private static void insertLogo(BufferedImage source, String logoPath, boolean needCompress) throws Exception {
        File file = new File(logoPath);
        if (!file.exists()) {
            return;
        }
        Image src = ImageIO.read(new File(logoPath));
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

    public static int getQrCodeSize() {
        return qrCodeSize;
    }

    public static void setQrCodeSize(int qrCodeSize) {
        AminQrCode.qrCodeSize = qrCodeSize;
    }

    public static int getLogoWidth() {
        return logoWidth;
    }

    public static void setLogoWidth(int logoWidth) {
        AminQrCode.logoWidth = logoWidth;
    }

    public static int getLogoHeight() {
        return logoHeight;
    }

    public static void setLogoHeight(int logoHeight) {
        AminQrCode.logoHeight = logoHeight;
    }
}
