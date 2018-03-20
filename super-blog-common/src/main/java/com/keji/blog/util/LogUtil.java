package com.keji.blog.util;

import org.slf4j.Logger;

/**
 * 日志打印工具类
 *
 * @author wb-ny291824
 * @version $Id: LogUtil.java, v 0.1 2018-03-20 19:05 wb-ny291824 Exp $$
 */
public class LogUtil {

    /**
     * 记录debug日志
     *
     * @param logger logger
     * @param msg    错误信息=%s占位符
     * @param params 参数组
     */
    public static void debug(Logger logger, String msg, Object... params) {
        if (logger.isDebugEnabled()) {
            logger.debug(String.format(msg, params));
        }
    }

    /**
     * 记录info日志
     *
     * @param logger logger
     * @param msg    错误信息=%s占位符
     * @param params 参数组
     */
    public static void info(Logger logger, String msg, Object... params) {
        if (logger.isInfoEnabled()) {
            logger.info(String.format(msg, params));
        }
    }

    /**
     * 记录info信息
     *
     * @param logger logger
     * @param msg    错误信息
     */
    public static void info(Logger logger, String msg) {
        if (logger.isInfoEnabled()) {
            logger.info(msg);
        }
    }

    /**
     * 记录warn日志
     *
     * @param logger logger
     * @param e 异常
     * @param msg 错误信息
     * @param params 参数
     */
    public static void warn(Logger logger, Throwable e, String msg, Object... params) {
        logger.warn(String.format(msg, params), e);
    }

    /**
     * 记录warn日志
     *
     * @param logger logger
     * @param msg    错误信息
     * @param params 参数
     */
    public static void warn(Logger logger, String msg, Object... params) {
        logger.warn(String.format(msg, params));
    }

    /**
     * 记录error日志
     *
     * @param logger logger
     * @param e 异常
     * @param msg 错误信息
     * @param params 参数
     */
    public static void error(Logger logger, Throwable e, String msg, Object... params) {
        logger.error(String.format(msg, params), e);
    }

    /**
     * 记录error日志
     *
     * @param logger logger
     * @param msg    错误信息
     * @param params 参数
     */
    public static void error(Logger logger, String msg, Object... params) {
        logger.error(String.format(msg, params));
    }

}
