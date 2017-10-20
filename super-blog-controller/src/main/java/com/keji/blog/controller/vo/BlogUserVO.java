package com.keji.blog.controller.vo;

import lombok.Data;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/9/18
 * @modified: By:
 */
@Data
public class BlogUserVO {

    /**
     * 登录邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 记住我
     */
    private Boolean rememberMe;
}
