package com.enterprise.results;

import com.enterprise.EnterpriseNoAppropriateConstructorFoundException;
import com.enterprise.model.MetaTestData;
import com.enterprise.model.Status;

import java.time.LocalTime;

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

    public static MetaTestData testString(String expected, String actual, LocalTime elapsedRunTime, Throwable badStuff){
        Status status;
        String message;
        if (badStuff instanceof EnterpriseNoAppropriateConstructorFoundException) {
            status = Status.NEVER_RAN;
            message = "there was an error. \n error: "+badStuff.toString();
        } else if (badStuff != null){
            status = Status.ERRORED;
            message = "there was an error. \n error: "+badStuff.toString();
        } else if(expected.equals(actual)){
            status = Status.PASSED;
            message = "parameters match. \n parameters: "+expected;
        } else {
            status = Status.FAILED;
            message = "parameters did not match. \n expected: "+expected+"\t actual: "+actual;
        }
        return new MetaTestData(status, expected, actual, message, badStuff, elapsedRunTime);
    }

    // In case they don't want to give us a throwable.
    public static MetaTestData testString(String expected, String actual, LocalTime elapsedRunTime){
        return testString(expected, actual, elapsedRunTime, null);
    }
}
