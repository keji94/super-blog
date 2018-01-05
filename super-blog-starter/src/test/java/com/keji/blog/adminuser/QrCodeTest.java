package com.keji.blog.adminuser;

import java.awt.*;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.keji.blog.ApplicationTests;
import org.junit.Test;

/**
 * @author wb-ny291824
 * @version $Id: QrCodeTest.java, v 0.1 2018-01-03 16:59 wb-ny291824 Exp $$
 */
public class QrCodeTest extends ApplicationTests{

    /**
     * 二维码的编码格式
     */
    private static final String CHARSET = "utf-8";

    @Test
    public void test() throws Exception{

        //设置二维码的参数
        Hashtable<EncodeHintType, Object> hints = new Hashtable<>(3);
        // 设置QR二维码的纠错级别（H为最高级别）具体级别信息
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        //设置二维码的编码格式
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        //设置二维码的边界
        hints.put(EncodeHintType.MARGIN, 1);

        String content = "克己";
        int qrCodeSize = 400;

        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, qrCodeSize, qrCodeSize,
                hints);
    }

    @Test
    public void testFont() {

        Font font = new Font(null, Font.BOLD, 30);
        System.out.println(font);

    }

}
