package com.keji.blog.servlet.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author: wb-ny291824
 * @Description session监听器。
 *                  创建：服务器端第一次调用getSession()
 *                  销毁：    * 非正常关闭服务器(正常关闭session会序列化):
                              * session过期了,默认30分钟.
                              * 手动调用session.invalidate();
 * @Date: Created in 2017/9/19
 * @Modified: By:
 */
//@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("HttpSession被创建了...");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("HttpSession被销毁了...");
    }
}
