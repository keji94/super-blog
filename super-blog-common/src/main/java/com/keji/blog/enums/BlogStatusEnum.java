package com.keji.blog.enums;

/**
 * @author wb-ny291824
 * @version $Id: BlogStatusEnum.java, v 0.1 2017-10-26 15:20 wb-ny291824 Exp $$
 */
public enum  BlogStatusEnum {
    /**
     * 正常
     */
    NORMAL(0, "正常"),
    /**
     * 停用
     */
    STOP_USE(1,"停用");

    private Integer key;

    private String value;

    BlogStatusEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
