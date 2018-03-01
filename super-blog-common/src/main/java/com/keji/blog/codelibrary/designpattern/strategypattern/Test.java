package com.keji.blog.codelibrary.designpattern.strategypattern;

/**
 * 策略模式测试类
 *      1.定义了一个超类鸭子。鸭子的飞行行为和叫的行为是会变化的，所以单独以接口的形式提取出去。
 *          如果需要增加一种飞行行为，只需要增加一个FlyBehavior的实现类即可。
 *      2.超类Duck 的成员变量有飞行行为和叫行为。
 *      3.不同的鸭子都继承至超类duck，不管怎么飞怎么叫，只需要在构造方法中，给成员变量具体的实现即可。
 *
 * @author wb-ny291824
 * @version $Id: Test.java, v 0.1 2018-03-01 10:17 wb-ny291824 Exp $$
 */
public class Test {

    public static void main(String[] args) {
        AbstractDuck duck = new MallardDuck();
        duck.performFly();
        duck.performQuack();
    }
}
