package com.lhyzp.common.annotation;

import java.lang.annotation.*;

/**
 * 操作日志注解
 * Created by Administrator on 2017-10-21.
 */
@Target(ElementType.METHOD)  //用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
@Retention(RetentionPolicy.RUNTIME)  //表示需要在什么级别保存该注释信息，用于描述注解的生命周期（即：被描述的注解在什么范围内有效）
@Documented
public @interface OpLog {
    String value() default "";

}
