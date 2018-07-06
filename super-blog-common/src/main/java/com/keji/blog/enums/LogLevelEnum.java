package com.keji.blog.enums;

/**
 * 日志级别枚举
 *
 * @author keji
 * @version $Id: LogLevelEnum.java, v 0.1 2018/7/6 上午10:59 keji Exp $
 */
public enum LogLevelEnum {
    /**
     * info级别日志
     */
    INFO(1),

    /**
     * warn级别
     */
    WARN(2),

    /**
     * error级别
     */
    ERROR(3),

    /**
     * debug级别
     */
    DEBUG(4);

    private int key;
    LogLevelEnum(int key){
        this.key = key;
    }

    public int getKey(){
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
