package com.keji.blog.vo.user;

import java.util.Date;
import lombok.Data;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/9/18
 * @modified: By:
 */
@Data
public class UserVO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 登录邮箱
     */
    private String email;

    /**
     * 安全问题
     */
    private String question;

    /**
     * 头像
     */
    private String picture;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 密码
     */
    private String password;

    /**
     * 记住我
     */
    private String rememberMe;

}
