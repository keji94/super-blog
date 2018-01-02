package com.keji.blog.util;

import java.io.Closeable;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * IO流工具类
 *
 * @author wb-ny291824
 * @version $Id: IOUtil.java, v 0.1 2017-12-19 11:22 wb-ny291824 Exp $$
 */
public class IOUtil {

    private static Logger logger = LoggerFactory.getLogger(IOUtil.class);

    private IOUtil() {}

    public static void close(Closeable...closeAbles) {
        try {
            for (Closeable closeable : closeAbles) {
                if (null != closeable) {
                    closeable.close();
                }
            }
        } catch (IOException e) {
            logger.error("关闭流发生异常");
        }
    }
}
