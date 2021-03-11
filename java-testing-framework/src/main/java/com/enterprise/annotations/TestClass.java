package com.enterprise.annotations;


import java.lang.annotation.*;
/*
    This annotation is used to mark a class for inspection by the test runner.

    In order to find Test methods within a class this annotation must be present, note that not all methods
    in a test class must be test methods, but it is recommended to keep testing separate from the main codebase.
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
public @interface TestClass {

    String name() default "standard test class";
}

