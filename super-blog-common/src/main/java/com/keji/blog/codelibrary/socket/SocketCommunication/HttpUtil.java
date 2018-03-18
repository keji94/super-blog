package com.keji.blog.codelibrary.socket.SocketCommunication;


/**
 *
 * @author keji
 * @version $Id: HttpUtil.java, v 0.1 2018/3/18 下午3:00 keji Exp $
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
