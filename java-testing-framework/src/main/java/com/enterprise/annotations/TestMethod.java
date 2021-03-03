package com.enterprise.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
//TODO: Change Annotation to take generics
public @interface TestMethod {

    String name() default "standard test";
    String expected() default "expected";
}
