package com.keji.blog.enums;


/**
 * @author: wb-ny291824
 * @description  给前端视图的提示
 * @date: Created in 2017/9/21
 * @modified: By:
 */
public enum ViewTipEnum {
    /**
     * 登录提示
     */
    LOGIN_TIP("login","请登录!") ;

    private String key;

    private String value;

    ViewTipEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
