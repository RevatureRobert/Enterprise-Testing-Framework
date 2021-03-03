package com.enterprise.annotations;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestClass {

    String name() default "standard test class";
}

