package com.keji.blog.codelibrary.designpattern.observerpattern;

/**
 * 主题
 *
 * @author wb-ny291824
 * @version $Id: Subject.java, v 0.1 2018-03-01 14:59 wb-ny291824 Exp $$
 */
public interface Subject {

    /**
     * 注册观察者
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 删除观察者
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知所有观察者。当主题状态改变时，这个方法会被调用。
     */
    void notifyObserver();

}
