package com.enterprise.util;

import com.enterprise.annotations.TestMethod;

public class TestClass1 {
    @TestMethod(name = "test1",expected = "result1")
    public String testMethod1 () {
        return "result1";
    }
    @TestMethod(name = "test2",expected = "result1")
    public String testMethod2 () {
        return "result2";
    }
    @TestMethod(name = "test2",expected = "result3")
    public String testMethod3 () throws Exception {
        throw new Exception("This is our exeption");
    }
}
