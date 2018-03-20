package com.keji.blog.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author wb-ny291824
 * @version $Id: UserDO.java, v 0.1 2018/3/20 10:26 wb-ny291824 Exp $
 */
@Data
public class UserDO implements Serializable{

    private static final long serialVersionUID = 1142535723756188983L;

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
     * 手机
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 安全问题
     */
    private String question;

    /**
     * 安全问题答案
     */
    private String answer;

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
     * 修改时间
     */
    private Date gmtModified;

    /**
     * ip地址
     */
    private String ip;

}