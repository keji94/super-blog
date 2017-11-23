package com.keji.blog.bean;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

import com.alibaba.druid.util.DaemonThreadFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author wb-ny291824
 * @version $Id: JavaBean.java, v 0.1 2017-11-06 10:15 wb-ny291824 Exp $$
 */
@Configuration
public class JavaBean {

    /**
     * 线程池:初始线程5,最大线程10，最大阻塞线程10,线程工厂使用德鲁伊,线程数量爆炸由AbortPolicy处理
     * @return
     */
    @Bean(name = "executor")
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(5, 10, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(10), new DaemonThreadFactory("myThreadFactory"), new AbortPolicy());
    }

}
