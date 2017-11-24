package annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017-11-24.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {

    String value() default "";

}
