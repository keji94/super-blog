package com.keji.blog.codelibrary.designpattern.装饰者模式;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 自定义IO装饰者测试
 *
 * @author wb-ny291824
 * @version $Id: IOTest.java, v 0.1 2018-03-01 18:55 wb-ny291824 Exp $$
 */
public class IOTest {


    public static void main(String[] args) {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
            while ((c = in.read()) > 0) {
                System.out.println((char)c);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
