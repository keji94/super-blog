package com.keji.blog.annotion;

import com.keji.blog.enums.LogLevelEnum;
import com.keji.blog.enums.LogOccurredTypeEnum;
import com.keji.blog.enums.LogOutputTypeEnum;

/**
 * 方法注解
 *
 * @author keji
 * @version $Id: methodlog.java, v 0.1 2018/7/6 上午10:32 keji Exp $
 */
public @interface MethodLog {

    /**
     * 日志级别
     * @return 日志级别
     */
    LogLevelEnum level() default LogLevelEnum.INFO;

    /**
     * 日志输出类型，默认打印出参和入参
     * @return 输出类型
     */
    LogOutputTypeEnum type() default LogOutputTypeEnum.ALL;

    /**
     * 日志打印时机，默认正常
     * @return 打印时机
     */
    LogOccurredTypeEnum occurrType() default LogOccurredTypeEnum.NORMAL;

    /**
     * 有效期 日期格式
     * 支持的格式包括： yyyy-MM-dd yyyy-MM-dd HH:mm:ss
     * @return 过期时间
     */
    String expireTime() default "";

}


