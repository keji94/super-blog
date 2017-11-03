package com.keji.blog.codelibrary.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

import com.alibaba.druid.util.DaemonThreadFactory;

import org.junit.Test;

/**
 * 其中比较容易让人误解的是：corePoolSize，maximumPoolSize，workQueue之间关系。
 *
 * 1.当线程池小于corePoolSize时，新提交任务将创建一个新线程执行任务，即使此时线程池中存在空闲线程。
 * 2.当线程池达到corePoolSize时，新提交任务将被放入workQueue中，等待线程池中任务调度执行
 * 3.当workQueue已满，且maximumPoolSize>corePoolSize时，新提交任务会创建新线程执行任务
 * 4.当提交任务数超过maximumPoolSize时，新提交任务由RejectedExecutionHandler处理
 * 5.当线程池中超过corePoolSize线程，空闲时间达到keepAliveTime时，关闭空闲线程
 * 6.当设置allowCoreThreadTimeOut(true)时，线程池中corePoolSize线程空闲时间达到keepAliveTime也将关闭
 *
 * 总结：
 * 1、用ThreadPoolExecutor自定义线程池，看线程是的用途，如果任务量不大，可以用无界队列，如果任务量非常大，要用有界队列，防止OOM
 * 2、如果任务量很大，还要求每个任务都处理成功，要对提交的任务进行阻塞提交，重写拒绝机制，改为阻塞提交。保证不抛弃一个任务
 * 3、最大线程数一般设为2N+1最好，N是CPU核数
 * 4、核心线程数，看应用，如果是任务，一天跑一次，设置为0，合适，因为跑完就停掉了，如果是常用线程池，看任务量，是保留一个核心还是几个核心线程数
 * 5、如果要获取任务执行结果，用CompletionService，但是注意，获取任务的结果的要重新开一个线程获取，如果在主线程获取，就要等任务都提交后才获取，就会阻塞大量任务结果，队列过大OOM，所以最好异步开个线程获取结果
 *
 * @author wb-ny291824
 * @version $Id: ThreadPoolDemo.java, v 0.1 2017-11-03 16:15 wb-ny291824 Exp $$
 */
public class ThreadPoolDemo {

    /**
     * 方式一:使用ThreadPoolExecutor的方式创建线程池，这也是代码规范中推荐的。
     */
    @Test
    public void createThreadPoolByThreadPoolExecutor() {
        //核心线程池大小
        int corePoolSize = 5;
        //最大线程池大小
        int maximumPoolSize = 10;
        //	线程池中超过corePoolSize数目的空闲线程最大存活时间；可以allowCoreThreadTimeOut(true)使得核心线程有效时间
        int keepAliveTime = 10;
        //keepAliveTime的时间单位
        TimeUnit unit = TimeUnit.SECONDS;
        //阻塞任务队列
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
        //线程工厂
        ThreadFactory threadFactory = new DaemonThreadFactory("myThreadFactory");
        //当提交任务数超过maxmumPoolSize+workQueue之和时，任务会交给RejectedExecutionHandler来处理
        AbortPolicy abortPolicy = new AbortPolicy();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, queue,
                threadFactory, abortPolicy);
    }

    /**
     * 方式二:使用Executors创建线程池(不推荐)
     *
         线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样
         的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
         说明： Executors 返回的线程池对象的弊端如下：
         1） FixedThreadPool 和 SingleThreadPool:
         允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
         2） CachedThreadPool 和 ScheduledThreadPool:
         允许的创建线程数量为 Integer.MAX_VALUE， 可能会创建大量的线程，从而导致 OOM。
     */
    @Test
    public void createThreadPoolByExecutors() {
        //创建一个固定长度的线程池，每当提交一个任务就创建一个线程，直到达到线程池的最大数量，这时线程规模将不再变化，当线程发生未预期的错误而结束时，线程池会补充一个新的线程
        ExecutorService service1 = Executors.newFixedThreadPool(10);
        //创建一个可缓存的线程池，如果线程池的规模超过了处理需求，将自动回收空闲线程，而当需求增加时，则可以自动添加新线程，线程池的规模不存在任何限制
        ExecutorService service2 = Executors.newCachedThreadPool();
        //这是一个单线程的Executor，它创建单个工作线程来执行任务，如果这个线程异常结束，会创建一个新的来替代它；它的特点是能确保依照任务在队列中的顺序来串行执行
        ExecutorService service3 = Executors.newSingleThreadExecutor();
        //创建了一个固定长度的线程池，而且以延迟或定时的方式来执行任务，类似于Timer。
        ScheduledExecutorService service4 = Executors.newScheduledThreadPool(10);
    }

}
