package com.enterprise.util;

import com.enterprise.annotations.TestClass;
import com.enterprise.annotations.TestMethod;
import com.enterprise.model.MetaTestData;
import com.enterprise.results.TestResultsAPI;

@TestClass
public class TestClass1 {
    @TestMethod
    public MetaTestData<?,?> testEmptyTest () {
        return null;
    }
    @TestMethod
    public MetaTestData<?,?> defaultTestConstructorTest() {
        return new MetaTestData<>();
    }
    @TestMethod
    public MetaTestData<?,?> testStringTestOne () throws Exception {
        return TestResultsAPI.testString("one", "one");

    }
    @TestMethod
    public int testMethodInt1() {   return 5;   }
}

