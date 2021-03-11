package com.enterprise.annotations;

import java.lang.annotation.*;



//Annotation used to mark a Test for the test gatherer.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface TestMethod {

    String name() default "standard test";
}
