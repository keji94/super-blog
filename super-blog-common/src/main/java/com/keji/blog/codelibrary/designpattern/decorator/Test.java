package com.keji.blog.codelibrary.designpattern.decorator;

/**
 * 装饰者模式测试
 *
 * @author wb-ny291824
 * @version $Id: Test.java, v 0.1 2018-03-01 17:37 wb-ny291824 Exp $$
 */
public class Test {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + "$" + beverage.cost());

        Beverage beverage1 = new HouseBlend();
        beverage1 = new Soy(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);

        System.out.println(beverage1.getDescription() + "$" +beverage1.cost());
    }

}
