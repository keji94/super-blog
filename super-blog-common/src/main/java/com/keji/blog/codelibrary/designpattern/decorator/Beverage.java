package com.keji.blog.codelibrary.designpattern.decorator;

/**
 * 饮料 抽象组件
 *
 * @author wb-ny291824
 * @version $Id: Beverage.java, v 0.1 2018-03-01 17:18 wb-ny291824 Exp $$
 */
public abstract class Beverage {

    String description = "unkown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

}
