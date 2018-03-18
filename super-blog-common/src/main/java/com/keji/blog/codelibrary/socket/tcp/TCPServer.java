package com.keji.blog.codelibrary.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP协议严格区分服务端和客户端，只有客户端能够连接服务端，连接需要三次握手
 *
 * @author keji
 * @version $Id: TCPServer.java, v 0.1 2018/3/18 下午3:01 keji Exp $
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1,创建服务器ServerSocket对象（指定服务器端口号）
        ServerSocket ss = new ServerSocket(8888);
        //2，开启服务器了，等待客户端的连接，当客户端连接后，可以获取到连接服务器的客户端Socket对象
        Socket s = ss.accept();
        //3,给客户端反馈信息
        /*
		 * a,获取客户端的输出流
		 * b,在服务端端，通过客户端的输出流写数据给客户端
		 */
        //a,获取客户端的输出流
        OutputStream out = s.getOutputStream();
        //b,在服务端端，通过客户端的输出流写数据给客户端
        out.write("你已经连接上了服务器".getBytes());
        //4,关闭流资源
        out.close();
        s.close();
        //ss.close();  服务器流 通常都是不关闭的
    }

}
