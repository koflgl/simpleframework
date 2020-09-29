package com.lgl.simpleframework.framework.inject.annotation;

import java.lang.annotation.*;

/**
 * 支持成员变量级别
 * @author lgl
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
    String value() default "";
}
