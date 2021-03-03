package com.enterprise.util;

import com.enterprise.EnterpriseNoAppropriateConstructorFoundException;
import com.enterprise.annotations.TestClass;
import com.enterprise.annotations.TestMethod;
import com.enterprise.model.MetaTestData;
import com.enterprise.model.Stopwatch;
import com.enterprise.results.TestResultsAPI;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class TestDiscovery {


    public Method[] getTestMethods(Class clazz) {
        // TODO: replace with collection that is dynamic in size, good for frequently adding
        //      does not allow duplicates,
        if (clazz == null) {
            return null;
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
        Reflections reflections = new Reflections("com.");
        //System.out.println(reflections.toString());

        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(TestClass.class);

        int i = 0;
        Class[] result = new Class[classes.size()]; {
            for (Class c: classes
                 ) {
                result[i++] = c;
            }
        }
        return result;
    }

    public HashMap<Method,MetaTestData> runAndStoreTestInformation() throws EnterpriseNoAppropriateConstructorFoundException {

        HashMap<Method,MetaTestData> results = new HashMap<Method,MetaTestData>();
        Class[] testClasses = getTestClasses();

        for(Class c: testClasses) {
            for (Method m: getTestMethods(c)) {
                String expected;
                if (m !=null && m.getDeclaredAnnotation(TestMethod.class).expected() !=null) {
                    expected = m.getDeclaredAnnotation(TestMethod.class).expected();
                } else {
                    continue;
                }
                Stopwatch stop = new Stopwatch();
                try {
                    stop.startStopwatch();
                    String actual = m.invoke(c.getConstructors()[0].newInstance()).toString();
                    stop.stopStopWatch();
                    results.put(m,TestResultsAPI.testString(expected,actual,stop.getElapsedTime()));
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    stop.stopStopWatch();
                    results.put(m,TestResultsAPI.testString(expected,"EXCEPTION",stop.getElapsedTime(),e));
                    //throw new EnterpriseNoAppropriateConstructorFoundException();
                } catch (Exception e) {
                    stop.stopStopWatch();
                    results.put(m,TestResultsAPI.testString(expected,"EXCEPTION",stop.getElapsedTime(),e));
                }
            }
        }

        //Method m = methods[0];
        // TODO: check if there is a no arg constructor, if there is not then throw an exception
        //try {
        //    m.invoke(clazz.getConstructors()[0].newInstance());
            // TODO: Get information from the map to to inform the developer about the tests that were ran
       // } catch (Exception e){
       //     throw new EnterpriseNoAppropriateConstructorFoundException();
       // }
        return results;
    }
}
