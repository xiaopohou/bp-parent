package com.lhyzp.web.common.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017-11-15.
 */
public class Test2 {
    public static void main(String[] args) {
        //创建委托对象
        RealSubject realSubject=new RealSubject();
        //创建代理对象
        ProxyHandler proxyHandler=new ProxyHandler(realSubject);
        Subject subject= (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),RealSubject.class.getInterfaces(),proxyHandler);
        subject.printName("赵丽颖");
    }
}
