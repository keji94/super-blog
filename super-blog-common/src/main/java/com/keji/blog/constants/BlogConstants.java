package com.keji.blog.constants;

/**
 *
 * @author keji
 * @version $Id: BlogConstants.java, v 0.1 2018/3/23 下午9:22 keji Exp $
 */
public class BlogConstants {

    private BlogConstants(){}

    public static final String LOGIN_ERROR = "*用户名或者密码不正确";

    public static final String ADMIN_USER_NAME = "admin@qq.com";

    public static final String USER_NAME_STRING = "username";

    public static final String USER_ID_STRING = "userId";

    /**
     * 博客文案缓存key
     */
    public static final String TEXT_SETTINGS_KEY = "textSettingsDO";
    /**
     * 导航缓存key
     */
    public static final String NAV_KEY = "navDO";
    /**
     * 标签缓存key
     */
    public static final String TAG_KEY = "tagDO";

    /**
     * 文章缓存
     */
    public static final String ARTICLE_KEY = "articleDO";

    /**
     * 信息板缓存key
     */
    public static final String INFO_BOARD_KEY = "infoBoard";
    /**
     * 分类信息缓存key
     */
    public static final String CATEGORY_KEY = "category";

    /**
     * 员工姓名校验正则:2-6位无生僻字中文
     */
    public static final String NAME_REGULAR = "[\\u4e00-\\u9fa5]{2,6}";

    /**
     * 电话校验正则：1开头，11位数字
     */
    public static final String PHONE_REGULAR = "^1[0-9]{10}$";

    /**
     * 任务调度参数key
     */
    public static final String JOB_PARAM_KEY = "JOB_PARAM_KEY";

    /**
     * 文章预览长度
     */
    public static final int ARTICLE_SUMMARY_LENGTH = 150;

}
