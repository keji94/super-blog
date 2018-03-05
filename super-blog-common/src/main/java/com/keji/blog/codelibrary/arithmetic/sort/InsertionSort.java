package com.keji.blog.codelibrary.arithmetic.sort;

/**
 * 插入排序
 * 在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
 * 时间复杂度O(n2)
 * @author wb-ny291824
 * @version $Id: InsertionSort.java, v 0.1 2018/3/5 15:44 wb-ny291824 Exp $
 */
public class InsertionSort {
    public static void main(String[] args) {
        
    }

    public static void insertSort(int[] array, int length) {
        int temp;
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j >0 ; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j - 1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }else {
                    break;
                }
            }
        }
    }
}
