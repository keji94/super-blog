package com.keji.blog.codelibrary.servlet.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


/**
 * 监听request对象的创建和销毁
 *                  * 创建：客户端向服务器发送一次请求,服务器就会创建request对象.
 * 销毁：服务器对这次请求作出响应后就会销毁request对象.
 * @author keji
 * @version $Id: MyServletRequestListener.java, v 0.1 2018/3/18 下午2:58 keji Exp $
 */
//@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("ServletRequest被销毁了...");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("ServletRequest被创建了...");
    }
}
