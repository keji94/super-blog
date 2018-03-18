package com.keji.blog.codelibrary.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP通信的发送端
 * @author keji
 * @version $Id: UDPSend.java, v 0.1 2018/3/18 下午3:02 keji Exp $
 */
public class UDPSend {
    public static void main(String[] args) throws IOException {
        //1,创建DatagramSocket对象
        DatagramSocket sendSocket = new DatagramSocket();
        //2，创建DatagramPacket对象，并封装数据
        //public DatagramPacket(byte[] buf, int length, InetAddress address,  int port)
        //构造数据报包，用来将长度为 length 的包发送到指定主机上的指定端口号。
        byte[] buffer = "hello,udp".getBytes();
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("10.63.14.38"), 12306);
        //3，发送数据
        //public void send(DatagramPacket p) 从此套接字发送数据报包
        sendSocket.send(dp);
        //4，释放流资源
        sendSocket.close();
    }

}

