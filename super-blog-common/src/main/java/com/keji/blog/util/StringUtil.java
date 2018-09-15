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
     * 定义script的正则表达式
     */
    private static final String REGEX_SCRIPT = "<script[^>]*?>[\\s\\S]*?<\\/script>";
    /**
     * 定义style的正则表达式
     */
    private static final String REGEX_STYLE = "<style[^>]*?>[\\s\\S]*?<\\/style>";
    /**
     * 定义HTML标签的正则表达式
     */
    private static final String REGEX_HTML = "<[^>]+>";
    /**
     * 定义空格回车换行符
     */
    private static final String REGEX_SPACE = "\\s*|\t|\r|\n";

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

    public static String delHtmlTag(String strWithHtml) {
        Pattern patternScript = Pattern.compile(REGEX_SCRIPT, Pattern.CASE_INSENSITIVE);
        Matcher m = patternScript.matcher(strWithHtml);
        String strWithoutScript = m.replaceAll("");

        Pattern patternStyle = Pattern.compile(REGEX_STYLE, Pattern.CASE_INSENSITIVE);
        Matcher mStyle = patternStyle.matcher(strWithoutScript);
        String strWithoutStyle = mStyle.replaceAll("");

        Pattern patternHtml = Pattern.compile(REGEX_HTML, Pattern.CASE_INSENSITIVE);
        Matcher mHtml = patternHtml.matcher(strWithoutStyle);
        String strWithoutHtml = mHtml.replaceAll("");

        Pattern patternSpace = Pattern.compile(REGEX_SPACE, Pattern.CASE_INSENSITIVE);
        Matcher mSpace = patternSpace.matcher(strWithoutHtml);
        String strWithoutSpace = mSpace.replaceAll("");

        return strWithoutSpace.replaceAll("&nbsp", "");
}

}
