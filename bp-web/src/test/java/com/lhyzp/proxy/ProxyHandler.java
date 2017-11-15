package com.lhyzp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类的调用处理器
 * Created by Administrator on 2017-11-15.
 */
public class ProxyHandler implements InvocationHandler{

    private Subject subject;

    public ProxyHandler(Subject subject){
        this.subject=subject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行前-----");
        Object result = method.invoke(subject, args);
        System.out.println("方法执行后-----");

        return result;
    }
}
