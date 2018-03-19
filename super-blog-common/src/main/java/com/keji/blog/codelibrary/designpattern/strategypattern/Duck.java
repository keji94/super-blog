package com.keji.blog.codelibrary.designpattern.strategypattern;

/**
 * 鸭子超类
 *
 * @author wb-ny291824
 * @version $Id: Duck.java, v 0.1 2018-03-16 16:56 wb-ny291824 Exp $$
 */
public abstract class Duck {

    /**
     * 腿的数量
     */
    protected int legs;

    /**
     * 飞行
     */
    public void fly() {
        System.out.println("I can fly");
    }

    /**
     * 叫
     */
    public void quack() {
        System.out.println("呱呱呱");
    }
}
