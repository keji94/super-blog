package com.keji.blog.enums;

/**
 * @author: wb-ny291824
 * @description 评论表枚举
 * @date: Created in 2017/10/23
 * @modified: By:
 */
public enum RequirementStatusEnum {

    /**
     * 新建
     */
    NEW(0, "新建"),
    /**
     * 开发中
     */
    DEVELOPING(1,"开发中"),
    /**
     * 开发完成
     */
    FINISHED(2,"完成"),
    /**
     * 放弃
     */
    GIVEUP(3,"放弃");

    private Integer key;

    private String value;

    RequirementStatusEnum(Integer key, String value) {
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
