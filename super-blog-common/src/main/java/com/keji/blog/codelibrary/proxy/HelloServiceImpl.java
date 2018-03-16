package com.keji.blog.codelibrary.proxy;

/**
 * @author wb-ny291824
 * @version $Id: HelloServiceImpl.java, v 0.1 2018-03-12 11:08 wb-ny291824 Exp $$
 */
public class HelloServiceImpl implements HelloService{
    @Override
    public void sayHello(String name) {
        System.out.println("Hello..." + name);
    }
}
