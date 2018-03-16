package com.keji.blog.codelibrary.arithmetic.sort;

/**
 * 冒泡排序
 * 依次比较相邻的两个数，将小数放在前面，大数放在后面。
 即在第一趟：
 　　首先比较第1个和第2个数，将小数放前，大数放后;
 　　然后比较第2个数和第3个数，将小数放前，大数放后，如此继续，直至比较最后两个数，将小数放前，大数放后;
 　　至此第一趟结束，将最大的数放到了最后。
 在第二趟：
 　　仍从第一对数开始比较（因为可能由于第2个数和第3个数的交换，使得第1个数不再小于第2个数），将小数放前，大数放后;
 　　一直比较到倒数第二个数（倒数第一的位置上已经是最大的）;
 　　第二趟结束，在倒数第二的位置上得到一个新的最大数（其实在整个数列中是第二大的数）。
 如此下去，重复以上过程，直至最终完成排序。
 * @author wb-ny291824
 * @version $Id: BubbleSort.java, v 0.1 2018/3/5 15:44 wb-ny291824 Exp $
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1,5,6,21,24,121,11,14,23};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(arr[i]);
        }
    }

    private static void bubbleSort(int[] data) {
        int temp;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}
