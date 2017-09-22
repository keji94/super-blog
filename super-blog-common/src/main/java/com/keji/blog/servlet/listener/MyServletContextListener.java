package com.keji.blog.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author: wb-ny291824
 * @Description 自定义监听器，使用@WebListener.此监听器监听ServletContext对象的创建和销毁。
 *                  创建：服务器启动的时候,服务器为每个WEB应用创建一个属于该web项目的对象ServletContext.
 *                  销毁：服务器关闭或者项目从服务器中移除的时候.
 *                企业级应用：
 *                  1.加载配置文件，如spring的ContextLoaderListener
 *                  2.定时任务调度。
 * @Date: Created in 2017/9/19
 * @Modified: By:
 */
//@WebListener
public class MyServletContextListener implements ServletContextListener {

    /**
     *监听ServletContext的创建
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext创建了...");
    }

    /**
     * 监听ServletContext的销毁
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext销毁了...");
    }
}
