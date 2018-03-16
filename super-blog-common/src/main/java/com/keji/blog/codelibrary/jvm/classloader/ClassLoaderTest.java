package com.keji.blog.codelibrary.jvm.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * 简单的类加载器，参考深入Java虚拟机第7章
 *
 * @author wb-ny291824
 * @version $Id: ClassLoaderTest.java, v 0.1 2018-03-14 19:48 wb-ny291824 Exp $$
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception{
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (null == is) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("com.keji.blog.codelibrary.jvm.classloader.ClassLoaderTest").newInstance();

        System.out.println(obj.getClass());

        //这一句的结果是false，因为虚拟机中存在两个该类，一个是系统加载的类，一个是我们自己定义的类加载器加载进来的类。虽然来自同一个Class文件，但是依旧是两个独立的类。
        System.out.println(obj instanceof com.keji.blog.codelibrary.jvm.classloader.ClassLoaderTest);
    }
}
