package com.enterprise.results;

import com.enterprise.model.MetaTestData;
import com.enterprise.model.Status;
//ToDO:rename?
public class TestResultsAPI {
    public static <A> MetaTestData<String,?> testString(String expected, A actual){
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

            mt.setStatus(Status.EXCEPTION_THROWN);
            mt.setActual((A) e);
        }
        return mt;
    }
    //
    public static <E,A> MetaTestData<E,A> testObject(E expected, A actual){
        MetaTestData<E, A> mt = new MetaTestData<>();
        mt.setExpected(expected);
        try {
            if(expected.equals(actual)){
                mt.setStatus(Status.PASSED);
            } else {
                mt.setStatus(Status.FAILED);

            }
            mt.setActual(actual);
        } catch (Exception e) {

            mt.setStatus(Status.EXCEPTION_THROWN);
            mt.setActual((A) e);
        }
        return mt;
    }

}
