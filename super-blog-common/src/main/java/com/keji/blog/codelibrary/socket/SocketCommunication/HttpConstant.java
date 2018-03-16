package com.keji.blog.codelibrary.socket.SocketCommunication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wb-ny291824 on 2017/8/22.
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
