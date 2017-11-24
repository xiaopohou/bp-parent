package annotation;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * 注解
 * Created by Administrator on 2017-11-24.
 */
public class AnnotationDemo {


    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        //方法1：<T extends Annotation> T getAnnotation(Class<T> annotationClass): 返回改程序元素上存在的、指定类型的注解，如果该类型注解不存在，则返回null。
        //
        //方法2：Annotation[] getAnnotations():返回该程序元素上存在的所有注解。
        //
        //方法3：boolean isAnnotationPresent(Class<?extends Annotation> annotationClass):判断该程序元素上是否包含指定类型的注解，存在则返回true，否则返回false.
        //
        //方法4：Annotation[] getDeclaredAnnotations()：返回直接存在于此元素上的所有注释。与此接口中的其他方法不同，该方法将忽略继承的注释。
        // （如果没有注释直接存在于此元素上，则返回长度为零的一个数组。）该方法的调用者可以随意修改返回的数组；这不会对其他调用者返回的数组产生任何影响。

        User user=new User();

        //目标：简易自动自动建表

        Class<? extends User> userClass = user.getClass();
        //获取注解
        Entity entity = userClass.getAnnotation(Entity.class);
        if(entity!=null){
            //表名
            String tableName;
            Table table = userClass.getAnnotation(Table.class);
            if(table!=null){
                //获取自定义表的名称
                String custTanleName = table.value();
                if(!"".equals(custTanleName) && custTanleName!=null){
                    tableName=custTanleName;
                }else{
                    tableName=userClass.getSimpleName().toLowerCase();
                }
            }else{
                tableName=userClass.getSimpleName().toLowerCase();
            }

            StringBuilder createSql=new StringBuilder("create table ");
            createSql.append(tableName);
            createSql.append("(");

            //字段
            Field[] fields = userClass.getDeclaredFields();
            for (Field field:fields) {
                //判断是否存在Column注解,这里是存在这个注解才算字段
                if(field.isAnnotationPresent(Column.class)){
                    String fieldName = field.getName();
                    Class<?> type = field.getType();

                    //判断类型
                    if(type==String.class){
                        createSql.append(field.getName());
                        createSql.append(" VARCHAR2(50),");
                    }else if(type == Integer.class){
                        createSql.append(field.getName());
                        createSql.append(" NUMBER(11),");
                    }else if(type == Short.class){
                        createSql.append(field.getName());
                        createSql.append(" NUMBER(1),");
                    }else if(type == Date.class){
                        createSql.append(field.getName());
                        createSql.append(" DATE,");
                    }
                }
            }

            String sql = createSql.substring(0, createSql.length() - 1)+")";

            System.out.println("创建表语句："+sql);
        }


    }
}
