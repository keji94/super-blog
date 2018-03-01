package com.keji.blog.codelibrary.designpattern.装饰者模式;

/**
 * 另一种饮料 具体组件
 *
 * @author wb-ny291824
 * @version $Id: HouseBlend.java, v 0.1 2018-03-01 17:23 wb-ny291824 Exp $$
 */
public class HouseBlend extends Beverage{

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
