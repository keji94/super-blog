package com.keji.blog.codelibrary.socket.SocketCommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by wb-ny291824 on 2017/8/22.
 * 1.成功建立 socket 连接后，我们就能获得它的输入输出流，通信的本质是对输入输出流的处理
 *      。通过输入流，读取网络连接上传来的数据，通过输出流，将本地的数据传出给远端。
 * 2.关于 IO 流的处理，我们一般会用相应的包装类来处理 IO 流，如果直接处理的话，我们需要对 byte[] 进行操作，而这是相对比较繁琐的。
 *      如果采用包装类，我们可以直接以string、int等类型进行处理，简化了 IO 字节操作。
 */
public class SocketHttpClient {

    public void start(String host, int port) {
        //初始化socket
        Socket socket = new Socket();
        try {
            //1.设置socket连接
            SocketAddress remote = new InetSocketAddress(host, port);
            socket.setSoTimeout(5000);
            socket.connect(remote);

            //发起请求
            PrintWriter writer = getWriter(socket);
            System.out.println(HttpUtil.compositeRequest(host));
            writer.write(HttpUtil.compositeRequest(host));//发生IO阻塞
            writer.flush();

            //读取响应
            String msg;
            BufferedReader reader = getReader(socket);
            while ((msg = reader.readLine()) != null) {//发生IO阻塞
                System.out.println(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(in));
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream out = socket.getOutputStream();
        return new PrintWriter(new OutputStreamWriter(out));
    }
}
