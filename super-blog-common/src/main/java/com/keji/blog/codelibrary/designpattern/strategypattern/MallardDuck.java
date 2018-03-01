package com.keji.blog.codelibrary.designpattern.strategypattern;

/**
 *  野鸭
 *
 * @author wb-ny291824
 * @version $Id: MallardDuck.java, v 0.1 2018-03-01 10:12 wb-ny291824 Exp $$
 */
public class MallardDuck extends AbstractDuck{

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I am a real MallardDuck");
    }
}
