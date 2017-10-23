package com.keji.blog.codelibrary.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author: wb-ny291824
 * @description 流的中间操作：
 * filter、map、limit、sorted、distinct
 * 流的终端操作:
 * forEach、totalCount、collect
 * @date: Created in 2017/10/10
 * @modified: By:
 */
public class StreamDemoTest {

    private static final List<Dish> MENU = Dish.MENU;


    /**
     * 简单的演示
     */
    @Test
    public void demo1() {
        //获取流
        List<String> result = MENU.stream()
            //筛选
                .filter(dish -> dish.getCalories() > 300)
            //获取菜名
                .map(Dish::getName)
            //只选择头三个
                .limit(3)
            //将结果保存在另外一个list中
                .collect(toList());
        System.out.println(result);
    }

    /**
     * 流只能消费一次
     */
    @Test
    public void demo2() {
        List<String> list = Arrays.asList("java8", "good", "very good");
        Stream<String> s = list.stream();
        s.forEach(System.out::println);
        //报错：java.lang.IllegalStateException: stream has already been operated upon or closed
        s.forEach(System.out::println);
    }


    /**
     * 中间操作和终端操作
     */
    @Test
    public void demo3() {
        long count = MENU.stream()
                .filter(dish -> dish.getCalories() > 300)    //中间操作
                .count();                                   //终端操作
        System.out.println(count);
    }

    /**
     * 筛选出所有的偶数，并且没有重复
     */
    @Test
    public void demo4() {
        List<Integer> list = Arrays.asList(1, 2, 1, 3, 3, 2, 4, 4, 6, 8);
        list.stream()
                .filter(i -> i % 2 == 0)
                .distinct()     //去重
                .forEach(System.out::println);
    }

    /**
     * 跳过元素，流还支持skip(n)方法，返回一个扔掉了前n个元素的流。如果流中元素不足n个，则返回一
     * 个空流。请注意， limit(n)和skip(n)是互补的！
     */
    @Test
    public void demo5() {
        MENU.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(3)
                .forEach(System.out::println);
    }


    /**
     * map操作:统计每个字符串的长度
     */
    @Test
    public void demo6() {
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> list = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(list);
    }

    /**
     * map操作：找出每道菜的名称多长
     */
    @Test
    public void demo7() {
        List<Integer> list = MENU.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println(list);
    }


    /**
     * 流的扁平化：给 定 单 词 列 表["Hello","World"]，你想要返回列表["H","e","l", "o","W","r","d"]。
     */
    @Test
    public void demo8() {
        List<String> words = Arrays.asList("Hello", "World");
        List<String> uniqueCharacters =
                words.stream()
                        .map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList());
    }

    /**
     * 匹配：anyMatch
     */
    @Test
    public void demo9() {
        boolean b = MENU.stream().anyMatch(Dish::isVegetarian);
        if (b) {
            System.out.println("HAHAHAA");
        }
    }

    /**
     * 匹配:allMatch(所有都匹配)
     */
    @Test
    public void demo10() {
        boolean b = MENU.stream().allMatch(dish -> dish.getCalories() < 100);
        if (b) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }

    /**
     * 匹配:noneMatch(所有都不匹配)
     */
    @Test
    public void demo11() {
        boolean b = MENU.stream().noneMatch(dish -> dish.getCalories() < 100);
        if (b) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }

    /**
     * 查找：findAny
     *      Optional<T>类（java.util.Optional）是一个容器类，代表一个值存在或不存在。java 8的库设计人员引入了Optional<T>，这
            样就不用返回众所周知容易出问题的null了。
         Optional里面几种可以迫使你显式地检查值是否存在或处理值不存在的情形的方法也不错。
          isPresent()将在Optional包含值的时候返回true, 否则返回false。
          ifPresent(Consumer<T> block)会在值存在的时候执行给定的代码块。我们在第3章
         介绍了Consumer函数式接口；它让你传递一个接收T类型参数，并返回void的Lambda
         表达式。
          T get()会在值存在时返回值，否则抛出一个NoSuchElement异常。
          T orElse(T other)会在值存在时返回值，否则返回一个默认值。
     */
    @Test
    public void demo12() {
        MENU.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d-> System.out.println(d.getName()));

    }

    /**
     * 查找：findFirst
     */
    @Test
    public void demo13() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findFirst(); // 9
    }

    /**
     * 归约:求和
     */
    @Test
    public void demo14() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = someNumbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(reduce);

    }

    /**
     * 归约：相乘
     */
    @Test
    public void demo15() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = someNumbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println(reduce);
    }

    /**
     * 归约：最值
     */
    @Test
    public void demo16() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> reduce = someNumbers.stream()
//                .reduce(Integer::max);
                .reduce(Integer::min);
        reduce.ifPresent(i-> System.out.println(i));
    }

    /**
     * 归约：计算流中的个数
     */
    @Test
    public void demo17() {
        //map-reduce模式
        Integer count = MENU.stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println(count);


        //内置的count
        long count1 = MENU.stream().count();
        System.out.println(count1);
    }

    /**
     *
     */
    @Test
    public void demo18() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1.找出2011年发生的所有交易，并按交易额排序（从低到高）。
        List<Transaction> list = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(toList());
        System.out.println(list);

        //2.交易员都在哪些不同的城市工作过？
        List<String> citys = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println(citys);

        //3.查找所有来自于剑桥的交易员，并按姓名排序
        List<Trader> list1 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(toList());
        System.out.println(list1);

        //4.返回所有交易员的姓名字符串，按字母顺序排序
        String nameString = transactions.stream().map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce("", (a, b) -> a + b);
        System.out.println(nameString);

        //5.有没有交易员是在米兰工作的？
        boolean b = transactions.stream().map(Transaction::getTrader)
                .anyMatch(trader -> "Milan".equals(trader.getCity()));
        System.out.println(b);

        //6.打印生活在剑桥的交易员的所有交易额。
        Integer value = transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(value);

        //7.所有交易中，最高的交易额是多少？
        Optional<Integer> maxValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        maxValue.ifPresent(value2-> System.out.println(value2));


        //8.找到交易额最小的交易。
        Optional<Integer> reduce = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        reduce.ifPresent(minValue-> System.out.println(minValue));
    }



}
