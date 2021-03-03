package com.enterprise.util;

import com.enterprise.annotations.TestMethod;
import com.enterprise.model.MetaTestData;

import java.lang.reflect.Method;

public class Driver {
    @TestMethod(name = "default test", expected = "main")
    public static void main(String[] args) {
        //HashMap <Class,Method[]> methodmap = new HashMap<Class, Method[]>();

        HashMap <Method, MetaTestData> resultmap = new HashMap<Method, MetaTestData>();
    }
}
