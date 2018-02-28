package com.keji.blog.codelibrary.arithmetic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

/**
 * 算法题目demo
 *
 * @author wb-ny291824
 * @version $Id: ArithmeticDemos.java, v 0.1 2018-02-27 14:08 wb-ny291824 Exp $$
 */
public class ArithmeticDemos {

    /**
     * 在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。
     * 给出一天中的股票变化序列，请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。
     *
     * 给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。
     * 测试样例：
     * [10，22，5，75，65，80]，6
     * 返回：87
     *
     * 思路：
     * mine:
     * 1.序列中的max-min = a1  --> 一次最大收益
     * 2.min左边的序列: max2-min2 = a2
     * 3.max右边的序列: max3-min3 = a3
     * 4.a2 > a3 ? a2 : a3 --> 第二次最大收益
     * 5.a1+4的结果  -->最终最大收益
     * mine2:
     * 1.定义索引start=0 end=0
     * 2.遍历list。将每一个元素和其后面一个元素比较:如果list.get(i+1)>=list.get(i). end=i+1
     * 3.如果list.get(i+1)<list.get(i).计算profit1=list.get(end)-list.get(index).start = i+1
     * 正解:
     */
    @Test
    public void demo1() {

        List<Integer> list = Arrays.asList(10, 22, 5, 75, 65, 80, 70, 5);
        int maxProfit = mineMethod(list);

        int[] prices = {10, 22, 5, 75, 65, 80,89};
        int maxProfit1 = maxProfit(prices, 7);
    }

    private int mineMethod(List<Integer> list) {

        int max = list.get(0);
        int maxCount = 0;
        int min = list.get(0);
        int minCount = 0;

        int maxProfit = max - min;
        int leftProfit = 0;
        int rightProfit = 0;

        //找到最大值，以及索引
        for (int i = 0; i < list.size(); i++) {
            if (max <= list.get(i)) {
                max = list.get(i);
                maxCount = i;
            }
        }

        //找到最大值索引前的最小值
        for (int i = 0; i < maxCount; i++) {
            if (min >= list.get(i)) {
                min = list.get(i);
                minCount = i;
            }
        }

        maxProfit = max - min;

        if (minCount >= 2) {
            //如果最小值的索引>=2，说明最小值之前还有操作空间。
            List<Integer> leftList = list.subList(0, minCount);
            int leftMax = Collections.max(leftList);
            int leftMin = Collections.min(leftList);
            leftProfit = leftMax - leftMin;
        }

        if (list.size() - maxCount - 1 >= 2) {
            //说明最大值之后还有操作空间
            List<Integer> rightList = Lists.newArrayList();

            for (int i = maxCount + 1; i < list.size(); i++) {
                rightList.add(list.get(i));
            }
            int rightMin = rightList.get(0);
            int rightMinCount = 0;
            int rightMax = 0;

            for (int i = 0; i < rightList.size(); i++) {
                //找到最小值以及最小值的索引
                if (rightMin >= rightList.get(i)) {
                    rightMin = rightList.get(i);
                    rightMinCount = i;
                }
            }
            if (rightMinCount < rightList.size() - 1) {
                //获取最小值后的最大值
                for (int i = rightMinCount; i < rightList.size(); i++) {
                    if (rightMax < rightList.get(i)) {
                        rightMax = rightList.get(i);
                    }
                }
            }

            rightProfit = rightMax - rightMin;
        }

        int sumProfit = maxProfit + (rightProfit - leftProfit > 0 ? rightProfit : leftProfit);

        return sumProfit;
    }

    /**
     * 这应该是最简单的算法了.答题思路，在每个价格点都买卖两次，保留最合理的操作
     * @param prices
     * @param n
     * @return
     */
    public static int maxProfit(int[] prices, int n) {
        int firstBuyProfit = Integer.MIN_VALUE;
        int firstSaleProfit = Integer.MIN_VALUE;
        int secondBuyProfit = Integer.MIN_VALUE;
        int secondSaleProfit = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            firstBuyProfit = Math.max(firstBuyProfit, -prices[i]);
            firstSaleProfit = Math.max(firstSaleProfit, firstBuyProfit + prices[i]);
            secondBuyProfit = Math.max(secondBuyProfit, firstSaleProfit - prices[i]);
            secondSaleProfit = Math.max(secondSaleProfit, secondBuyProfit + prices[i]);
        }
        return secondSaleProfit;
    }

}
