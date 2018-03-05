package com.keji.blog.codelibrary.arithmetic.sort;

/**
 * 选择排序
 *
 *  这一种简单的排序方法，它的基本思想是：
     R[n]
     第一次从R[0]~R[n-1]中选取最小值，与R[0]交换;
     第二次从R[1]~R[n-1]中选取最小值，与R[1]交换;
     ....，
     第i次从R[i-1]~R[n-1]中选取最小值，与R[i-1]交换;
     .....，
     第n-1次从R[n-2]~R[n-1]中选取最小值，与R[n-2]交换;
     总共通过n-1次,得到一个按排序码从小到大排列的有序序列.
     选择排序的平均时间复杂度是O(n²)的。
 * @author wb-ny291824
 * @version $Id: ChooseSort.java, v 0.1 2018/3/5 15:42 wb-ny291824 Exp $
 */
public class ChooseSort {

    public static void main(String[] args) {
        int[] arr = {1,5,6,21,24,121,11,14,23};
        chooseSort(arr);
        for ( int a :arr) {
            System.out.println(a);
        }
    }

    private static void chooseSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = i;
            for (int j = i+1; j <data.length ; j++) {
                if (data[min] > data[j]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = data[min];
                data[min] = data[i];
                data[i] = temp;
            }
        }
    }

}
