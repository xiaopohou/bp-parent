package com.lhyzp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 动态代码执行
 */
public class Test {



    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        String javaSrc = "public class TestClass{" +
                "public void sayHello(String msg) {" +
                "System.out.printf(\"Hello %s! This message from a Java String.%n\",msg);" +
                "}" +
                "public int add(int a,int b){" +
                "return a+b;" +
                "}" +
                "}";
        Map<String, byte[]> bytecode = DynamicLoader.compile("TestClass.java", javaSrc);
        DynamicLoader.MemoryClassLoader classLoader = new DynamicLoader.MemoryClassLoader(bytecode);
        Class clazz = classLoader.loadClass("TestClass");
        Object object = clazz.newInstance();
        Method method = clazz.getMethod("add", int.class, int.class);
        Object returnValue = method.invoke(object, 1, 2);
        System.out.println(returnValue);

        Method method2 = clazz.getMethod("sayHello", String.class);
        Object returnValue2 = method2.invoke(object, "jack");
        System.out.println(returnValue2);
    }

}
