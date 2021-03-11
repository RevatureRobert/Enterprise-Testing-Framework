package com.enterprise.util;

import com.enterprise.annotations.TestClass;
import com.enterprise.annotations.TestMethod;
import com.enterprise.model.MetaTestData;
import com.enterprise.model.Status;
import com.enterprise.results.TestResultsAPI;

@TestClass
public class ExampleTestClass {
    @TestMethod
    public MetaTestData<?,?> testEmptyTest () {
        return null;
    }
    @TestMethod
    public MetaTestData<?,?> defaultTestConstructorTest() {
        return new MetaTestData<>();
    }
    @TestMethod
    public MetaTestData<?,?> testStringTestOne () {
        return TestResultsAPI.testString("one", "one");

    }

    @TestMethod
    public int testMethodInt1() {   return 5;   }

    //Example unit(method) to test.
    public int sum(int a, int b) {
        return a * b;


    }

    @TestMethod
    public MetaTestData<Integer, Integer> sumTestTwoPlusTwo() {
        MetaTestData<Integer, Integer> r = new MetaTestData<>();
        r.setExpected(4);
        r.setActual(sum(2, 2));
        if (r.getActual().equals(r.getExpected())) {
            r.setStatus(Status.PASSED);
        } else {
            r.setStatus(Status.FAILED);
        }
        return r;
    }

    @TestMethod
    public MetaTestData<Integer, Integer> sumTestTwoPlusThree() {
        MetaTestData<Integer, Integer> r = new MetaTestData<>();
        r.setExpected(4);
        r.setActual(sum(2, 3));
        if (r.getActual().equals(r.getExpected())) {
            r.setStatus(Status.PASSED);
        } else {
            r.setStatus(Status.FAILED);
        }
        return r;
    }
}

