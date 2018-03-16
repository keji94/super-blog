package com.keji.blog.codelibrary.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * HelloService 代理
 *
 * @author wb-ny291824
 * @version $Id: HelloServiceProxy.java, v 0.1 2018-03-12 11:09 wb-ny291824 Exp $$
 */
public class HelloServiceProxy implements InvocationHandler{

    /**
     * 真实服务对象
     */
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 通过代理对象调用这个方法首先进入这个方法
     * @param proxy 代理对象
     * @param method 被调用的方法
     * @param args 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("########我是JDK动态代理########");
        Object result = null;
        //反射方法前调用
        System.out.println("我准备说Hello");
        //执行方法，相当于调用HelloServiceImpl类的sayHello方法
        result = method.invoke(target, args);
        //反射方法调用后
        System.out.println("我说过Hello了");
        return result;
    }
}
