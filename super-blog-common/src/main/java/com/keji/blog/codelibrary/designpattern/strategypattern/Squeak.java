package com.keji.blog.codelibrary.designpattern.strategypattern;

/**
 * 鸭子的另外一种叫法
 *
 * @author wb-ny291824
 * @version $Id: Squeak.java, v 0.1 2018-03-01 10:10 wb-ny291824 Exp $$
 */
public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("squeak");
    }
}
