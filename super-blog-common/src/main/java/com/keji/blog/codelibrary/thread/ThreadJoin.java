package com.keji.blog.codelibrary.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 面试题:现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执
            行？
 *  答：使用join方法。
 *
 *  Join方法原理: parent:父线程 child:子线程
 *      从源码可以看出Parent 调用 child.join()，child.join() 再调用 child.join(0) （此时 Parent 会获得 child 实例作为锁，其他线程可以进入 child.join() ，但不可以进入 child.join(0)， 因为没有获得锁），child.join(0) 会不断地检查 child 线程是否是 Active。

 如果是 Active，则不断地调用 child.wait(0)（此时 Parent 会释放 child 实例锁，其他线程可以竞争锁并进入 child.join(0)）。我们可以得知，Parent 线程在不断地对 child.wait(0) 入栈和出栈。

 一旦 child 线程不为 Active （状态为 TERMINATED）, child.join(0) 会直接返回到 child.join(), child.join() 会直接返回到 Parent 主线程，Parent 主线程就可以继续运行下去了。
        keji：简单点说，父线程会不断轮询子线程是否存活，存活不断wait(0)，不存活则父线程得以执行下去。
 *
 *
 * @author wb-ny291824
 * @version $Id: ThreadJoin.java, v 0.1 2018-02-28 11:11 wb-ny291824 Exp $$
 */
public class ThreadJoin {
    public static void main(String[] args) throws Exception{
        T3 t3 = new T3();
        t3.call();
    }
}

class T1 extends Thread{
    @Override
    public void run() {
        System.out.println("线程1执行了");
    }
}

class T2 implements Runnable{
    @Override
    public void run() {
        T1 t1 = new T1();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程2执行了");
    }
}

class T3 implements Callable<Integer> {

    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        //使用FutureTask包装
        FutureTask<Integer> futureTask = new FutureTask<>(myThread3);
        for(int i = 0;i < 100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);
            if(i==20)
            {
                new Thread(futureTask,"有返回值的线程").start();
            }
        }
        try
        {
            System.out.println("子线程的返回值："+futureTask.get());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        T2 t2 = new T2();
        Thread t21 = new Thread(t2, "T2");
        t21.start();
        t21.join();
        System.out.println("线程3执行了");
        return 1;
    }
}
