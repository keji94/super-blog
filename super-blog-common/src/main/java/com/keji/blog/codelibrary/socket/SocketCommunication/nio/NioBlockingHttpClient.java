package com.keji.blog.codelibrary.socket.SocketCommunication.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

import com.keji.blog.codelibrary.socket.SocketCommunication.HttpConstant;
import com.keji.blog.codelibrary.socket.SocketCommunication.HttpUtil;

/**
 * Created by wb-ny291824 on 2017/8/22.
 * Selector选择器能够监听所有的IO操作，并且以事件的方式通知我们那些IO已经就绪了。
 */
public class NioBlockingHttpClient {

    private SocketChannel socketChannel;
    private String host;
    private static Selector selector;
    private Charset charset = Charset.forName("utf8");

    static {
        try {
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public NioBlockingHttpClient(String host, int port) throws IOException {
        this.host = host;
        //初始化socket,简历socket与channel的绑定关系。
        socketChannel = SocketChannel.open();
        socketChannel.socket().setSoTimeout(5000);
        //初始化远程连接地址
        SocketAddress remote = new InetSocketAddress(this.host, port);
        //设置非阻塞模式,默认是true阻塞模式，只有在这之后的代码才是非阻塞的，之前的依然是阻塞。
        socketChannel.configureBlocking(false);
        //建立连接
        this.socketChannel.connect(remote);
        //将cosketChannel注册到选择器中
        socketChannel.register(selector, SelectionKey.OP_CONNECT
                                            |SelectionKey.OP_READ
                                            |SelectionKey.OP_WRITE); //设置连接、可读、可写事件监听
    }

    public static void main(String[] args) throws IOException {
        for (String host : HttpConstant.HOSTS) {
            NioBlockingHttpClient client = new NioBlockingHttpClient(host, HttpConstant.PORT);
            client.request();
        }
    }

    private void request() throws IOException {
        PrintWriter pw = getWriter(socketChannel.socket());
        BufferedReader br = getReader(socketChannel.socket());

        pw.write(HttpUtil.compositeRequest(host));
        pw.flush();
        String msg;
        while ((msg = br.readLine()) != null){
            System.out.println(msg);
        }
    }

    public void select() throws IOException {
        //获取就绪的socket个数
        while (selector.select() > 0) {
            //获取符合socket在选择器中对应的事件句柄key
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                it.remove();
                if (key.isConnectable()) {
                    //进行连接操作
                    connect(key);
                } else if (key.isWritable()) {
                    //进行写操作
                    write(key);
                } else if (key.isReadable()) {
                    //进行读操作
                    receive(key);
                }
            }

        }
    }

    private void connect(SelectionKey key) throws IOException {
        //获取事件句柄对应的SocketChannel
        SocketChannel channel =(SocketChannel) key.channel();
        //真正的完成socket连接
        channel.finishConnect();
        //打印连接信息
        InetSocketAddress remote = (InetSocketAddress) channel.socket().getRemoteSocketAddress();
        String host = remote.getHostName();
        int port = remote.getPort();
        System.out.println(String.format("访问地址：%s:%s 连接成功！",host,port));
    }
    private void write(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        InetSocketAddress remote = (InetSocketAddress) channel.socket().getRemoteSocketAddress();
        String host = remote.getHostName();

        //获取HTTP请求
        String request = HttpUtil.compositeRequest(host);
        System.out.println(request);

        //向SocketChannel写入事件
        channel.write(charset.encode(request));
        //修改SocketChannel所关心的事件
        key.interestOps(SelectionKey.OP_READ);
    }

    private void receive(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();
        String receiveData = charset.decode(buffer).toString();

        //当没有数据可读时，取消在选择器中的关联并关闭socket连接
        if ("".equals(receiveData)) {
            key.cancel();
            channel.close();
            return;
        }

        System.out.println(receiveData);
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream out = socket.getOutputStream();
        return new PrintWriter(out);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(in));
    }
}
