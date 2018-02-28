package com.keji.blog.codelibrary.thread.ConsumerAndProvider.BlockingQunene;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by wb-ny291824 on 2017/8/21.
 * 仓库类Storage实现缓冲区
 * 当然，你会发现这时对于public void produce(int num);和public void consume(int num);方法业务逻辑上的实现跟前面两个例子不太一样，
 * 没关系，这个例子只是为了说明BlockingQueue阻塞队列的使用。
 有时使用BlockingQueue可能会出现put()和System.out.println()输出不匹配的情况，这是由于它们之间没有同步造成的。
 当缓冲区已满，生产者在put()操作时，put()内部调用了await()方法，放弃了线程的执行，然后消费者线程执行，调用take()方法，
 take()内部调用了signal()方法，通知生产者线程可以执行，致使在消费者的println()还没运行的情况下生产者的println()先被执行，
 所以有了输出不匹配的情况。
 对于BlockingQueue大家可以放心使用，这可不是它的问题，只是在它和别的对象之间的同步有问题。
 */
public class Storage {
    // 仓库最大存储量
    private final int MAX_SIZE = 100;

    // 仓库存储的载体
    private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>(
            100);

    // 生产num个产品
    public void produce(int num)
    {
        // 如果仓库剩余容量为0
        if (this.list.size() == MAX_SIZE)
        {
            System.out.println("【库存量】:" + MAX_SIZE + "/t暂时不能执行生产任务!");
        }

        // 生产条件满足情况下，生产num个产品
        for (int i = 1; i <= num; ++i)
        {
            try
            {
                // 放入产品，自动阻塞
                this.list.put(new Object());
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            System.out.println("【现仓储量为】:" + this.list.size());
        }
    }

    // 消费num个产品
    public void consume(int num)
    {
        // 如果仓库存储量不足
        if (list.size() == 0)
        {
            System.out.println("【库存量】:0/t暂时不能执行生产任务!");
        }

        // 消费条件满足情况下，消费num个产品
        for (int i = 1; i <= num; ++i)
        {
            try
            {
                // 消费产品，自动阻塞
                list.take();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        System.out.println("【现仓储量为】:" + list.size());
    }

    // set/get方法
    public LinkedBlockingQueue<Object> getList()
    {
        return list;
    }

    public void setList(LinkedBlockingQueue<Object> list)
    {
        this.list = list;
    }

    public int getMAX_SIZE()
    {
        return MAX_SIZE;
    }
}
