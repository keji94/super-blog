package com.keji.blog.codelibrary.socket.SocketCommunication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

/**
 * Created by wb-ny291824 on 2017/8/22.
 */
public class Application {

    @Test
    public void requestHost() {
        new SocketHttpClient().start("www.baidu.com",80);

    }


    /**
     * 如果需要请求10个不同的站点,等第一个请求响应结束之后，才发起下一个站点的请求
     */
    @Test
    public void requsetHosts() {
        for (String host : HttpConstant.HOSTS) {
            new SocketHttpClient().start(host,HttpConstant.PORT);
        }
    }

    /**
     * 为了防止阻塞，上面的问题使用多线程进行处理.
     * 这样做的问题就是性能差，当并发量大的时候，服务器不一定承受的住。可以使用线程池处理。
     */

/*    public static void main(String[] args) {
        for (String host : HttpConstant.HOSTS) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    new SocketHttpClient().start(host,HttpConstant.PORT);
                }
            });
            t.start();
        }
    }*/

    /**
     * 使用线程池访问多个hosts。这种方式看起来非常好了，但是其实还可以优化。
     *
     * 因为这种方式在数据没有准备好时，线程还是会发生阻塞。如果使用1.4以后的nio可以解决这个问题。
     * 这种技术叫做IO多路复用。
     */
    public static void main(String[] args) {

        //使用工具类Executor创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (String host : HttpConstant.HOSTS) {
            Thread t = new Thread(new Runnable() { //这个地方不是创建线程，只是创建对象，重写run方法
                @Override
                public void run() {
                    new SocketHttpClient().start(host,HttpConstant.PORT);
                }
            });
            executorService.submit(t);  //使用这个来代替t.start()方法
            new SocketHttpClient().start(host,HttpConstant.PORT);
        }
    }
}
