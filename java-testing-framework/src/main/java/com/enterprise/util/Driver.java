package com.enterprise.util;

import com.enterprise.EnterpriseNoAppropriateConstructorFoundException;
import com.enterprise.annotations.TestClass;
import com.enterprise.annotations.TestMethod;
import com.enterprise.model.MetaTestData;
import com.enterprise.model.Status;

import java.lang.reflect.Method;
import java.util.Properties;
@TestClass
public class Driver {
    public static void main(String[] args) throws EnterpriseNoAppropriateConstructorFoundException {
        //HashMap <Class,Method[]> methodmap = new HashMap<Class, Method[]>();
        HashMap<Method, MetaTestData<?, ?>> resultmap = null;
        try {
            resultmap = new TestDiscovery().runAndStoreTestInformation();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(resultmap);
    }
//Example unit(method) to test.
    public int sum(int a, int b) {
        return a * b;


    }

//TODO:Document the formal structure for a valid test method in WUnit of which these two are an example?
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
