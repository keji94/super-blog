package com.keji.blog.codelibrary.socket;

import java.net.InetAddress;

/**
 * InetAddress类用于封装一个IP地址，并提供了一系列与IP地址相关的方法
 *
 * @author wb-ny291824
 * @version $Id: InetAddressDemo.java, v 0.1 2018/3/15 10:30 wb-ny291824 Exp $
 */
public class InetAddressDemo {

    public static void main(String[] args) throws Exception{
        InetAddress local = InetAddress.getLocalHost();
        InetAddress remote = InetAddress.getByName("www.baidu.com");
        System.out.println("Ip地址" + local.getHostAddress());
        System.out.println("百度的Ip地址" + remote.getHostAddress());
        System.out.println("百度的主机名" + remote.getHostAddress());

    }
}
