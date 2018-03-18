package com.keji.blog.codelibrary.socket.SocketCommunication;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author keji
 * @version $Id: HttpConstant.java, v 0.1 2018/3/18 下午3:00 keji Exp $
 */
public class HttpConstant {
    public static List<String> HOSTS = new ArrayList<>();
    public static final int PORT =80;

    static {
        initHOSTS();
    }

    private static void initHOSTS() {
        HOSTS.add("www.baidu.com");
        HOSTS.add("www.163.com");
        HOSTS.add("www.cnblogs.com");
    }
}
