package com.lhyzp.test;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * java8   demo
 */
@RunWith(SpringRunner.class)
//@SpringBootTest
public class Java8Junit {

    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    @Test
    public void hello() {
        System.out.println("hello world");
    }

    @Test
    public void test1(){
        //lambda表达式
        MathOperation x=(a,b)->a+b;
        System.out.println(x.operation(1,2));

        GreetingService gs=msg-> System.out.println(msg+"....");
        gs.sayMessage("jack");

        MathOperation y=(a,b)->a-b;

        System.out.println(operate(10,5,x));
        System.out.println(operate(10,5,y));

    }

    /**
     * optional
     */
    @Test
    public void test2(){

        //创建一个非null的
        Optional<String> str=Optional.of("java");
        //创建一个可以为null 的
        Optional<String> str1=Optional.ofNullable(null);

        //判断是否为null
        if(str.isPresent()){
            System.out.println(str.get());
            System.out.println(str1.isPresent());
        }
        System.out.println(str.orElse("有值时返回"));
        System.out.println(str1.orElse("没有值,返回此值"));

        System.out.println(str.orElseGet(()->"有值也是返回"));
        System.out.println(str1.orElseGet(()->"没有值可以做点什么在返回"));

        Optional<User> user=Optional.of(new User("jack"));

        System.out.println(user.map(user1 -> user1.getName()).map(name->name.toUpperCase()).orElseGet(()->"空的名字"));

    }




    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

    class User{
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
