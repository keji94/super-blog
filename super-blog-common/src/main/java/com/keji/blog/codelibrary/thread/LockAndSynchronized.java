package com.keji.blog.codelibrary.thread;

/**
 * Lock和Synchronized的区别:
 * 如果一个代码块被synchronized关键字修饰，当一个线程获取了对应的锁，并执行该代码块时，其他线程便只能一直等待直至占有锁的
 * 线程释放锁。事实上，占有锁的线程释放锁一般会是以下三种情况之一：
 * 占有锁的线程执行完了该代码块，然后释放对锁的占有；
 * 占有锁线程执行发生异常，此时JVM会让线程自动释放锁；
 * 占有锁线程进入 WAITING 状态从而释放锁，例如在该线程中调用wait()方法等。
 * synchronized 是Java语言的内置特性，可以轻松实现对临界资源的同步互斥访问。那么，为什么还会出现Lock呢？试考虑以下三种情况：
 *
 * Case 1 ：
 *      在使用synchronized关键字的情形下，假如占有锁的线程由于要等待IO或者其他原因（比如调用sleep方法）被阻塞了，但是又没有
 * 释放锁，那么其他线程就只能一直等待，别无他法。这会极大影响程序执行效率。因此，就需要有一种机制可以不让等待的线程一直无
 * 期限地等待下去（比如只等待一定的时间 (解决方案：tryLock(long time, TimeUnit unit)) 或者 能够响应中断 (解决方案：lockInterruptibly())），
 * 这种情况可以通过 Lock 解决。
 *
 * Case 2 ：
 *      我们知道，当多个线程读写文件时，读操作和写操作会发生冲突现象，写操作和写操作也会发生冲突现象，但是读操作和读操作不会发
 * 生冲突现象。但是如果采用synchronized关键字实现同步的话，就会导致一个问题，即当多个线程都只是进行读操作时，也只有一个线
 * 程在可以进行读操作，其他线程只能等待锁的释放而无法进行读操作。因此，需要一种机制来使得当多个线程都只是进行读操作时，
 * 线程之间不会发生冲突。同样地，Lock也可以解决这种情况
 * (解决方案：ReentrantReadWriteLock) 。
 *
 * Case 3 ：
 * 我们可以通过Lock得知线程有没有成功获取到锁 (解决方案：ReentrantLock) ，但这个是synchronized无法办到的。
 *
 * 上面提到的三种情形，我们都可以通过Lock来解决，但 synchronized 关键字却无能为力。事实上，Lock 是 java.util.concurrent.
 * locks包 下的接口，Lock 实现提供了比 synchronized
 * 关键字 更广泛的锁操作，它能以更优雅的方式处理线程同步问题。也就是说，Lock提供了比synchronized更多的功能。但是要注意以下几点：
 *
 * 1）synchronized是Java的关键字，因此是Java的内置特性，是基于JVM层面实现的。而Lock是一个Java接口，是基于JDK层面实现的，
 *  通过这个接口可以实现同步访问；
 * 2）采用synchronized方式不需要用户去手动释放锁，当synchronized方法或者synchronized代码块执行完之后，系统会自动让线程释放对锁的占用；而
 * Lock则必须要用户去手动释放锁，如果没有主动释放锁，就有可能导致死锁现象
 *
 * @author wb-ny291824
 * @version $Id: LockAndSynchronized.java, v 0.1 2018-02-28 11:35 wb-ny291824 Exp $$
 */
public class LockAndSynchronized {
}
