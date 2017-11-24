package reflection;


import org.junit.Test;

import java.lang.reflect.*;

/**
 * 反射demo
 * Created by Administrator on 2017-11-24.
 */
public class ReflectionDemo {
    @Test
    public void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //一、获取class对象

        //1.使用Class类的forName方法
        Class<?> person1Class = Class.forName("reflection.Person");

        //2.直接获取某一个对象的class
        Class<Person> person2Class = Person.class;

        //3.调用对象的getClass方法
        Person person3=new Person();
        Class<? extends Person> person3Class = person3.getClass();

        //判断是否为某个类的实例
        System.out.println(person1Class.isInstance(person3));

        //通过反射创建实例
        Object p1 = person1Class.newInstance();
        Person p11=(Person)p1;
        p11.setName("李冰冰");
        System.out.println(p11.toString());

        //获取构造器，通过构造器创建指定构造方法实例
        Constructor constructor=person1Class.getConstructor(String.class,Integer.class,String.class);
        Object p2 = constructor.newInstance("范冰冰",28,"女");
        System.out.println(p2.toString());

        //获取方法
        //getDeclaredMethods()方法返回类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
        Method[] declaredMethods = person1Class.getDeclaredMethods();
        for (Method m:declaredMethods) {
            //System.out.println(m.getName());
        }

        //getMethods()方法返回某个类的所有公用（public）方法，包括其继承类的公用方法。
        Method[] methods = person2Class.getMethods();
        for (Method m:methods) {
            //System.out.println(m);
        }

        //getMethod方法返回一个特定的方法，其中第一个参数为方法名称，后面的参数为方法的参数对应Class的对象
        Method method = person3Class.getMethod("add",int.class,int.class);
        System.out.println(method);

        //获取类的成员变量（字段）信息
        Field[] fields = person1Class.getFields();
        for (Field f:fields) {
            System.out.println("公有成员变量"+f);
        }
        Field[] declaredFields = person1Class.getDeclaredFields();
        for (Field f:declaredFields) {
            System.out.println("所有已声明的成员变量"+f);
        }

        //方法调用
        Object result = method.invoke(p1, 1, 2);
        System.out.println("调用方法："+result);

        //利用反射创建数组(比较特殊)
        Class<String> stringClass = String.class;
        Object array = Array.newInstance(stringClass, 25);
        Array.set(array,0,"A");
        Array.set(array,1,"B");
        Array.set(array,2,"C");
        Array.set(array,3,"D");
        Array.set(array,4,"E");
        System.out.println("获取："+Array.get(array,3));


    }

}
