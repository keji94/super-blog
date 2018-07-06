package com.keji.blog.codelibrary.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * 自定义zookeeper watcher
 *
 * @author keji
 * @version $Id: MyWatcher.java, v 0.1 2018/7/2 下午4:44 keji Exp $
 */
public class MyWatcher implements Watcher{

    ZooKeeper zooKeeper;

    String hostPost;

    public MyWatcher(String hostPost) {
        this.hostPost = hostPost;
    }

    void startZk() throws IOException {
        zooKeeper = new ZooKeeper(hostPost, 15000, this);
    }

    void stopZk() throws InterruptedException {
        zooKeeper.close();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public static void main(String[] args) throws Exception {
        MyWatcher watcher = new MyWatcher("127.0.0.1");
        watcher.startZk();
        Thread.sleep(60000);
        watcher.stopZk();
    }
}
