package com.keji.blog.codelibrary.designpattern.decorator;

/**
 * 大豆 具体的装饰者
 *
 * @author wb-ny291824
 * @version $Id: Mocha.java, v 0.1 2018-03-01 17:26 wb-ny291824 Exp $$
 */
public class Soy extends CondimentDecorator {

    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Soy";
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
}
