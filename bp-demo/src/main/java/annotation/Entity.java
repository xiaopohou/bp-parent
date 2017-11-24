package annotation;

import java.lang.annotation.*;

/**
 * ElementType取值：

 1.CONSTRUCTOR:用于描述构造器

 2.FIELD:用于描述域

 3.LOCAL_VARIABLE:用于描述局部变量

 4.METHOD:用于描述方法

 5.PACKAGE:用于描述包

 6.PARAMETER:用于描述参数

 7.TYPE:用于描述类、接口(包括注解类型) 或enum声明

 RetentionPoicy取值

 1.SOURCE:在源文件中有效（即源文件保留）

 2.CLASS:在class文件中有效（即class保留）

 3.RUNTIME:在运行时有效（即运行时保留）
 * Created by Administrator on 2017-11-24.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Entity {

}
