package com.keji.blog.codelibrary.designpattern.strategypattern;

/**
 * 不会飞
 *
 * @author wb-ny291824
 * @version $Id: FlyNoWay.java, v 0.1 2018-03-01 10:07 wb-ny291824 Exp $$
 */
public class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("I can not fly!");
    }
}
