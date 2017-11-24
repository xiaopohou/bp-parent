package annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017-11-24.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
    String value() default "";//表名
}
