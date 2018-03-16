package com.keji.blog.codelibrary.arithmetic.sort;

/**
 *  * 二分查找
 * 为了提高查找效率，可使用折半查找的方式，注意：这种查找只对有序的数组有效。
 * @author wb-ny291824
 * @version $Id: HalfSearch.java, v 0.1 2018/3/5 15:44 wb-ny291824 Exp $
 */
public class HalfSearch {
    public static void main(String[] args) {

    }

    public static int halfSearch(int[] arr, int key) {
        int min, mid, max;
        min = 0;
        max = arr.length - 1;
        mid = (max + min) / 2;
        while (arr[mid] != key) {
            if (key > arr[mid]) {
                min = mid+1;
            } else if (key < arr[mid]) {
                max = mid - 1;
            }

            if (min > max) {
                return -1;
            }
            mid = (max+min)/2;
        }
        return mid;

    }
}
