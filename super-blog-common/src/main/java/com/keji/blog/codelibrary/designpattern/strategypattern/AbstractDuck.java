package com.keji.blog.codelibrary.designpattern.strategypattern;

/**
 * 鸭子超类
 *
 * @author wb-ny291824
 * @version $Id: AbstractDuck.java, v 0.1 2018-03-01 9:55 wb-ny291824 Exp $$
 */
public abstract class AbstractDuck {

    /**
     * 鸭子飞行行为
     */
    public FlyBehavior flyBehavior;

    /**
     * 鸭子叫行为
     */
    public QuackBehavior quackBehavior;

    public AbstractDuck() {

    }

    /**
     * 鸭子展示自己行为
     */
    public abstract void display();

    /**
     * 鸭子飞方法，具体实现，怎么飞，委托给FlyBehavior
     */
    public void performFly() {
        flyBehavior.fly();
    }

    /**
     * 鸭子叫方法，具体实现，怎么叫，委托给QuackBehavior
     */
    public void performQuack() {
        quackBehavior.quack();
    }

    /**
     * 鸭子游泳
     */
    public void swim() {
        System.out.println("All duck float,even decoys!");
    }

}
