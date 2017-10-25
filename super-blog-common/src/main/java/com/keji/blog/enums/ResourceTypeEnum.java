package com.keji.blog.enums;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/24
 * @modified: By:
 */
public enum ResourceTypeEnum {
    /**
     * 目录
     */
    CATALOG(0),
    /**
     * 菜单
     */
    MENU(1),
    /**
     * 按钮
     */
    BUTTON(2);

    private int value;

    private ResourceTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
