package com.enterprise.util;

import com.enterprise.annotations.TestClass;
import com.enterprise.annotations.TestMethod;

public class TestClass0 {
    int i;
    public TestClass0(int j) {
        i = j;
    }
    @TestMethod
    public int blah () {
        return 0;
    }
}
