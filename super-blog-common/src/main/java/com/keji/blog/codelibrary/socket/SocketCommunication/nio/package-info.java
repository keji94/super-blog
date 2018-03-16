/**
 * Created by wb-ny291824 on 2017/8/22.
 * 知识点：
 *   nio 下 I/O 阻塞与非阻塞实现
     SocketChannel 介绍
     I/O 多路复用的原理
     事件选择器与 SocketChannel 的关系
     事件监听类型
     字节缓冲 ByteBuffer 数据结构
 *
 * 场景：
 *      在上一篇中，我们使用了java.net.socket类来实现了这样的需求，以一线程处理一连接的方式，并配以线程池的控制，貌似得到了当前的最优解。
 *      可是这里也存在一个问题，连接处理是同步的，也就是并发数量增大后，大量请求会在队列中等待，或直接异常抛出。
 *      为解决这问题，我们发现元凶处在“一线程一请求”上，如果一个线程能同时处理多个请求，那么在高并发下性能上会大大改善。
 *      这里就借住 JAVA 中的 nio 技术来实现这一模型。
 */
package com.keji.blog.codelibrary.socket.SocketCommunication.nio;