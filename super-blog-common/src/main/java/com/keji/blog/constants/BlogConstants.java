package com.keji.blog.constants;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/18
 * @modified: By:
 */
public class BlogConstants {

    private BlogConstants(){}

    public static final String LOGIN_ERROR = "*用户名或者密码不正确";

    public static final String ADMIN_USER_NAME = "admin@qq.com";

    public static final String USER_NAME_STRING = "username";

    public static final String USER_ID_STRING = "userId";

    /**
     * 员工姓名校验正则:2-6位无生僻字中文
     */
    public static final String NAME_REGULAR = "[\\u4e00-\\u9fa5]{2,6}";

    /**
     * 电话校验正则：1开头，11位数字
     */
    public static final String PHONE_REGULAR = "^1[0-9]{10}$";

}
