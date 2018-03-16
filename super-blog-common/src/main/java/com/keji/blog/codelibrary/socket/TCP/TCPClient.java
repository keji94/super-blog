package com.keji.blog.codelibrary.socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by wb-ny291824 on 2017/8/18.
 * TCP协议的客户端
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1，创建客户端Socket对象,（指定要连接的服务器地址与端口号）
        Socket s = new Socket("10.63.14.38", 8888);
        //2,获取服务器端的反馈回来的信息
        InputStream in = s.getInputStream();
        //获取获取流中的数据
        byte[] buffer = new byte[1024];
        //把流中的数据存储到数组中，并记录读取字节的个数
        int length = in.read(buffer);
        //显示数据
        System.out.println( new String(buffer, 0 , length) );
        //3,关闭流资源
        in.close();
        s.close();
    }

}
