package com.keji.blog.codelibrary.designpattern.observerpattern;

/**
 * 观察者接口
 *
 * @author wb-ny291824
 * @version $Id: Observer.java, v 0.1 2018-03-01 14:58 wb-ny291824 Exp $$
 */
public interface Observer {

    /**
     * 当气象观测值改变时，主题会把这些状态值当做方法的参数，传送给观察者。
     *
     * @param temp
     * @param humidity
     * @param pressure
     */
    void update(float temp, float humidity, float pressure);

}
