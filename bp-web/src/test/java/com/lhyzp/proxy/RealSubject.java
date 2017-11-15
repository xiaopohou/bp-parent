package com.lhyzp.proxy;

/**
 * 委托类
 * Created by Administrator on 2017-11-15.
 */
public class RealSubject implements Subject{

    @Override
    public void printName(String name) {
        System.out.println("print---"+name);
    }
}
