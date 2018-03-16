package com.keji.blog.codelibrary.socket.SocketCommunication;

/**
 * Created by wb-ny291824 on 2017/8/22.
 */
public class HttpUtil {

    /**
     * 请求数据的内容
     * @param host
     * @return
     */
    public static String compositeRequest(String host) {
        return "GET / HTTP/1.1\r\n" +
                "Host: " + host + "\r\n" +
                "User-Agent : curl/7.43.0\r\n" +
                "Accept : */*\r\n\r\n";
    }
}
