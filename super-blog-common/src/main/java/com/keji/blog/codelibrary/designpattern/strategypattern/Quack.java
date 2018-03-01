package com.keji.blog.codelibrary.designpattern.strategypattern;

/**
 * 鸭子叫
 *
 * @author wb-ny291824
 * @version $Id: Quack.java, v 0.1 2018-03-01 10:08 wb-ny291824 Exp $$
 */
public class Quack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("Quack..Quack..");
    }
}
