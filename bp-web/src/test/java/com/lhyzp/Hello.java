package com.lhyzp;

import java.lang.annotation.*;

/**
 * Created by zhoupeng on 2017/9/27.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Hello {
    String value() default "";
}
