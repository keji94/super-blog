package com.keji.blog.codelibrary.proxy;

import java.util.HashSet;

/**
 * @author wb-ny291824
 * @version $Id: Test.java, v 0.1 2018-03-12 11:16 wb-ny291824 Exp $$
 */
public class Test {
    public static void main(String[] args) {
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
        HelloService helloService = (HelloService)helloServiceProxy.bind(new HelloServiceImpl());
        helloService.sayHello("张三");
    }
}
