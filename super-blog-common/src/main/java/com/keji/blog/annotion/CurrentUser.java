package com.keji.blog.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 当前用户注解
 *
 * @author qinjiao
 * @version $Id: CurrentUser.java, v 0.1 2018-04-16 下午6:47 qinjiao Exp $$
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

    /**
     * 当前登录用户
     * @return string
     */
    String value() default "user";
}
