package com.keji.blog.codelibrary.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author wb-ny291824
 * @version $Id: HelloServiceCglib.java, v 0.1 2018-03-12 11:24 wb-ny291824 Exp $$
 */
public class HelloServiceCglib implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }

    /**
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("####我是cglib的动态代理####");
        //反射方法调用
        System.out.println("我准备说Hello");
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        //反射方法后调用
        System.out.println("我说过Hello了");
        return invokeSuper;
    }
}
