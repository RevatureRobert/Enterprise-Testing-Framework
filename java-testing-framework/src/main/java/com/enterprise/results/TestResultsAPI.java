package com.enterprise.results;

import com.enterprise.model.MetaTestData;
import com.enterprise.model.Status;

// TODO: Implement gathering the throwable case from the actual value and implement the stopwatch feature
public class TestResultsAPI {
    public static boolean testString(String expected, String actual, String message){
         MetaTestData mt = new MetaTestData();
         mt.setActual(actual);
         mt.setExpected(expected);
         mt.setMessage(message);
        if(expected.equals(actual)){
            mt.setStatus(Status.PASSED);
        } else {
            mt.setStatus(Status.FAILED);
        }

        // Get the calling method from the current threads stack
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        String caller = stack[2].getMethodName();

        System.out.println(caller);
        return false;
    }

    public static MetaTestData testString(String expected, String actual){
        MetaTestData mt = new MetaTestData();
        mt.setActual(actual);
        mt.setExpected(expected);
        mt.setMessage("parameters did not match. \n expected: "+expected+"\t actual: "+actual);
        if(expected.equals(actual)){
            mt.setStatus(Status.PASSED);
        } else {
            mt.setStatus(Status.FAILED);
        }
        return mt;
    }

}
