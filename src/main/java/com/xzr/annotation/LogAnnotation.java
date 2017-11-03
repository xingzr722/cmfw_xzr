package com.xzr.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by F on 2017/10/30.
 */
//指定该注解的作用范围
@Target(ElementType.METHOD)
//指定生命时长    运行时有效
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {
    public String  description() default "";
}
