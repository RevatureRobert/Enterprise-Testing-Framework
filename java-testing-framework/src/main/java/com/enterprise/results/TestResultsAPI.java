package com.enterprise.results;

import com.enterprise.model.MetaTestData;
import com.enterprise.model.Status;

// TODO: Implement gathering the throwable case from the actual value and implement the stopwatch feature
public class TestResultsAPI {
    public static <A> MetaTestData<?,?> testString(String expected, A actual){
        MetaTestData<String, A> mt = new MetaTestData<>();
        mt.setExpected(expected);
        try {
            if(expected.equals(actual)){
                mt.setStatus(Status.PASSED);
                mt.setActual(actual);
            } else {
                mt.setStatus(Status.FAILED);

                mt.setActual(actual);
            }
        } catch (Exception e) {

            mt.setStatus(Status.ERRORED);
            mt.setActual((A) e);
        }
        return mt;
    }
}
