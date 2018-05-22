package com.keji.blog.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.hutool.core.util.StrUtil;

/**
 *
 * @author keji
 * @version $Id: StringUtil.java, v 0.1 2018/5/17 下午7:58 keji Exp $
 */
public class StringUtil extends StrUtil{

    /**
     * 替换字符串中的特俗字符
     *
     * @param regEx 正则
     * @param string 要替换的字符串
     * @return 被替换后的字符串
     */
    public static String replaceSpecialChars(String regEx,String string) {
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(string);
        return m.replaceAll("");
    }

}
