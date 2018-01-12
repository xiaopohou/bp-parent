package com.lhyzp.web.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhoupeng on 2017/9/27.
 */
public class HelloAnnotation {

    @Hello(value="注解value值")
    public void print(String name){
        System.out.println("方法中的打印..."+name);
    }

    public void resolve(Class clazz){
        Method[] methods = clazz.getMethods();//获取类的所有方法
        for (Method method : methods) {
            if(method.isAnnotationPresent(Hello.class)){//是否存在这个注解
                Hello hello = method.getAnnotation(Hello.class);//获取这个注解
                System.out.println(hello.value());
                try {
                    System.out.println("方法执行前....");
                    method.invoke(clazz.newInstance(),"小明");
                    System.out.println("方法执行后...");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
