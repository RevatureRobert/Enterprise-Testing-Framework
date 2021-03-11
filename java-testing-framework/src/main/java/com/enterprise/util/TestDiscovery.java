package com.enterprise.util;

import com.enterprise.EnterpriseNoAppropriateConstructorFoundException;
import com.enterprise.annotations.TestClass;
import com.enterprise.annotations.TestMethod;
import com.enterprise.model.MetaTestData;
import com.enterprise.model.Status;
import com.enterprise.model.Stopwatch;
import org.reflections.Reflections;

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
        Method[] rArr = new Method[currentIndex];
        for (int i = 0; i < currentIndex; i++) {
            rArr[i] = tempArr[i];
        }
        return rArr;
    }

    // TODO: Implement this method to gather all the test classes and call the getTestMethods method
    public Class[] getTestClasses() {
        Reflections reflections = new Reflections("");
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

    public <E,A> HashMap<Method,MetaTestData<?,?>> runAndStoreTestInformation() throws EnterpriseNoAppropriateConstructorFoundException {

        HashMap<Method,MetaTestData<?,?>> results = new HashMap<>();
        Class[] testClasses = getTestClasses();

        for(Class c: testClasses) {
            for (Method m: getTestMethods(c)) {
                Stopwatch stop = new Stopwatch();
                try {
                    stop.startStopwatch();
                    MetaTestData<?,?> result = (MetaTestData<?, ?>) m.invoke(c.getConstructors()[0].newInstance());
                    stop.stopStopWatch();
                    result.setElapsedRunTime(stop.getElapsedTime());
                    results.put(m,result);
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    stop.stopStopWatch();
                    results.put(m,new MetaTestData<E,Throwable>(Status.NEVER_RAN,null,e,"Test not run",new EnterpriseNoAppropriateConstructorFoundException(),stop.getElapsedTime()));
                } catch (Exception e) {
                    stop.stopStopWatch();
                    results.put(m,new MetaTestData<String,Throwable>(Status.EXCEPTION_THROWN,  "unknown",e,"Exception escaped test.",e,stop.getElapsedTime()));
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
    public void outputTestResultSummary(){

        int tt = 0,pt = 0,et = 0,ft = 0;
        try {
            HashMap<Method,MetaTestData<?,?>> tr = runAndStoreTestInformation();
            System.out.println(tr);
            tt = tr.getSize();
            for (HashMap.Node<Method, MetaTestData<?, ?>> m : tr) {
                switch (m.data.getStatus()){

                    case PASSED:pt++;
                        break;
                    case FAILED: ft++;
                        break;
                    case EXCEPTION_THROWN: et++;
                        break;
                    case NEVER_RAN: et++;
                        break;
                }


            }
            StringBuilder ns;
            ns = new StringBuilder();
            ns.append("Tests gathered: ");
            ns.append(tt);
            ns.append(" Tests Passed: ");
            ns.append(pt);
            ns.append(" Tests Failed: ");
            ns.append(ft);
            ns.append(" Tests with errors: ");
            ns.append(et);
            System.out.println(ns);
        } catch (EnterpriseNoAppropriateConstructorFoundException e) {
            e.printStackTrace();
        }
    }
}
