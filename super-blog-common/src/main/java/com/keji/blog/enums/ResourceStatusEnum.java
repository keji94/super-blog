package com.keji.blog.enums;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/24
 * @modified: By:
 */
public enum ResourceStatusEnum {

    /**
     * 新建
     */
    NORMAL(0, "正常"),
    /**
     * 开发中
     */
    STOP_USE(1,"停用");

    private Integer key;

    private String value;

    ResourceStatusEnum(Integer key, String value) {
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
