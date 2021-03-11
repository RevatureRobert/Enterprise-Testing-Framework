package com.enterprise.annotations;

import java.lang.annotation.*;



/*
    In the William Enterprise Unit Testing Framework(WUnit),
    Test methods are used to test the functionality of non-test methods.
     Test Methods must return TestMetaData<E,A> where
     E is the type of the expected result and
     A is the type of the actual result. (Not that because the type of the
      actual result is not know, wildcards are typically used for A.)
      TODO:Enforce this contract (potentially with annotation refactor) at compile time.

      The TestResultsApi class contains static methods to aid in test evaluation.
      TODO:have more test options.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
//TODO: Change Annotation to take generics
public @interface TestMethod {

    String name() default "standard test";
}
