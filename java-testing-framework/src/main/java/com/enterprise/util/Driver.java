package com.enterprise.util;

import com.enterprise.EnterpriseNoAppropriateConstructorFoundException;
import com.enterprise.annotations.TestMethod;
import com.enterprise.model.MetaTestData;

import java.lang.reflect.Method;

public class Driver {
    public static void main(String[] args) throws EnterpriseNoAppropriateConstructorFoundException {
        //HashMap <Class,Method[]> methodmap = new HashMap<Class, Method[]>();
        HashMap <Method, MetaTestData> resultmap = null;
        try {
             resultmap = new TestDiscovery().runAndStoreTestInformation();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(resultmap);
    }
}
