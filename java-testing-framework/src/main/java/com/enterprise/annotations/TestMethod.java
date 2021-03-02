package com.enterprise.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface                            TestMethod {

    String name() default "standard test";
}
