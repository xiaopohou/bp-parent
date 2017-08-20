package com.lhyzp;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Administrator on 2017-8-9.
 */
public class Java8Demo {



    public static void main(String[] args) {

        //lambda表达式
        //Runnable r=()-> System.out.println("do something");
        //r.run();
        //
        //new Thread(()-> System.out.println("do somthing2")).start();
        //
        //
        //boolean isAult=doPredicate(18,x->x>=18);
        //System.out.println(isAult);
        //
        //
        //Arrays.asList(new Person("Joe"),new Person("Jack"),new Person("小明")).forEach(e-> System.out.println(e.getName()));


    }




    //判断年龄是否大于多少
     public static boolean doPredicate(int age,Predicate<Integer> predicate){
        return predicate.test(age);
    }





    //函数式接口
    @FunctionalInterface
    interface Predicate<T>{
        boolean test(T t);
    }



}
