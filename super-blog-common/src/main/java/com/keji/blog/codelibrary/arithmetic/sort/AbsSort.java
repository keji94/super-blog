package com.keji.blog.codelibrary.arithmetic.sort;

/**
 *
 * 按绝对值排序。
 * 在冒泡排序的基础上，使用Math.abs()方法来获得绝对值进行比较。
 * @author wb-ny291824
 * @version $Id: AbsSort.java, v 0.1 2018/3/5 15:43 wb-ny291824 Exp $
 */
public class AbsSort {
    public static void main(String[] args) {
        int[] arr = {-10, -1, -5, 6, 2, 20};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (Math.abs(arr[j])>Math.abs(arr[j+1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
