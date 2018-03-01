package com.keji.blog.codelibrary.designpattern.strategypattern;

/**
 * 会飞的鸭子实现类
 *
 * @author wb-ny291824
 * @version $Id: FlyWithWings.java, v 0.1 2018-03-01 10:06 wb-ny291824 Exp $$
 */
public class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("I can fly!");
    }
}
