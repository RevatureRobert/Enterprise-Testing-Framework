package com.enterprise.util;

import com.enterprise.EnterpriseNoAppropriateConstructorFoundException;
import com.enterprise.annotations.TestMethod;
import com.enterprise.model.MetaTestData;
import com.enterprise.results.TestResultsAPI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestDiscovery {


    public Method[] getTestMethods(Class clazz) {
        // TODO: replace with collection that is dynamic in size, good for frequently adding
        //      does not allow duplicates,
        if (clazz == null) {
            return new Method[0];
        }
        Method[] tempArr = new Method[clazz.getMethods().length];
        int currentIndex = 0;
        for (Method m : clazz.getMethods()) {
            if (m.getDeclaredAnnotation(TestMethod.class) != null) {
                tempArr[currentIndex++] = m;
            }
        }

        return tempArr;
    }

    // TODO: Implement this method to gather all the test classes and call the getTestMethods method
    public Class[] getTestClasses() {
        return null;
    }

    public MetaTestData[] runAndStoreTestInformation(Class clazz) throws EnterpriseNoAppropriateConstructorFoundException {
        Method[] methods = getTestMethods(clazz);


        Method m = methods[0];
        // TODO: check if there is a no arg constructor, if there is not then throw an exception
        try {
            m.invoke(clazz.getConstructors()[0].newInstance());
            // TODO: Get information from the map to to inform the developer about the tests that were ran
        } catch (Exception e){
            throw new EnterpriseNoAppropriateConstructorFoundException();
        }
        return null;
    }

    public static void main(String[] args) {
        TestResultsAPI.testString("bob","bob","message");
    }

}
