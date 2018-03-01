package com.keji.blog.codelibrary.designpattern.装饰者模式;

/**
 * 调料 抽象装饰者
 *
 * @author wb-ny291824
 * @version $Id: CondimentDecorator.java, v 0.1 2018-03-01 17:19 wb-ny291824 Exp $$
 */
public abstract class CondimentDecorator extends Beverage{

    public abstract String getDescription();
}
