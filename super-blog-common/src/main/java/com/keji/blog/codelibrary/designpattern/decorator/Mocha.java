package com.keji.blog.codelibrary.designpattern.decorator;

/**
 * 摩卡 具体的装饰者
 *
 * @author wb-ny291824
 * @version $Id: Mocha.java, v 0.1 2018-03-01 17:26 wb-ny291824 Exp $$
 */
public class Mocha extends CondimentDecorator{

    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+",Mocha";
    }

    @Override
    public double cost() {
        return 0.20+beverage.cost();
    }
}
