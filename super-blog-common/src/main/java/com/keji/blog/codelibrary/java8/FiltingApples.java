package com.keji.blog.codelibrary.java8;

import org.springframework.aop.ThrowsAdvice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wb-ny291824
 * @description  使用策略设计模式，行为参数化。
 * @date: Created in 2017/9/24
 * @modified: By:
 */
public class FiltingApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));

//        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
//        List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
//        System.out.println(greenApples2);
//
//        // [Apple{color='green', weight=155}]
//        List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
//        System.out.println(heavyApples);
//
//        // []
//        List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
//        System.out.println(redAndHeavyApples);
//
//        // [Apple{color='red', weight=120}]
//        List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
//            public boolean test(Apple a){
//                return a.getColor().equals("red");
//            }
//        });
//        System.out.println(redApples2);

        /**
         *  TODO 不清楚原理
         */
        List<Apple> temp = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(temp);

        /**
         * java8排序
         */
        inventory.sort((Apple a,Apple b)->a.getWeight().compareTo(b.weight));
        System.out.println(inventory);

        //Thread t = new Thread(() -> System.out.println("hello"));
        //t.run();
    }


    /**
     * 接受一个ApplePredicate类型的实体，并且调用其test()方法
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    interface ApplePredicate{
        /**
         * 测试
         * @param a
         * @return
         */
        public boolean test(Apple a);
    }

    static class AppleWeightPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple){
            return apple.getWeight() > 150;
        }
    }
    static class AppleColorPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple){
            return "green".equals(apple.getColor());
        }
    }

    static class AppleRedAndHeavyPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple){
            return "red".equals(apple.getColor())
                    && apple.getWeight() > 150;
        }
    }

    /**
     * 苹果类
     */
    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
