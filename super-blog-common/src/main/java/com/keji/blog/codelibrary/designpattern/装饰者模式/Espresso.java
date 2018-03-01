package com.keji.blog.codelibrary.designpattern.装饰者模式;

/**
 * 饮料：浓缩咖啡
 *
 * @author wb-ny291824
 * @version $Id: Espresso.java, v 0.1 2018-03-01 17:22 wb-ny291824 Exp $$
 */
public class Espresso extends Beverage{

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
