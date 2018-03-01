package com.keji.blog.codelibrary.designpattern.strategypattern;

/**
 * 不叫
 *
 * @author wb-ny291824
 * @version $Id: MuteQuack.java, v 0.1 2018-03-01 10:09 wb-ny291824 Exp $$
 */
public class MuteQuack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("Silence!");
    }
}
