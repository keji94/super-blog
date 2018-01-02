package com.keji.blog.codelibrary.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;

/**
 * IO基础代码demo
 * 字节流：
 *      接口:InputStream,OutputStream
 *      实现:FileInputStream,FileOutputStream
 *      缓存:BufferedInputStream,BufferedOutputStream
 * 字符流:
 *      接口:Reader,Writer
 *      实现:FileReader,FileWriter
 *
 * @author wb-ny291824
 * @version $Id: IODemo.java, v 0.1 2017-12-19 14:09 wb-ny291824 Exp $$
 */
public class IODemo {

    /**
     * 1、FileInputStream
     */
    @Test
    public void demo1() throws Exception {
        //构造方法:使用字符串类型的文件名来创建一个输入流对象来读取文件：
        InputStream is = new FileInputStream("C:/java/hello");

        //构造方法:也可以使用一个文件对象来创建一个输入流对象来读取文件
        File file = new File("C:/java/hello");
        InputStream out = new FileInputStream(file);

    }

}
