package com.enterprise.results;

import com.enterprise.model.MetaTestData;
import com.enterprise.model.Status;
//ToDO:rename?
public class TestResultsAPI {


    private TestResultsAPI instance;
    private TestResultsAPI(){ this.instance = new TestResultsAPI(); }

    public TestResultsAPI getInstance(){ if (null == instance){ return new TestResultsAPI();} else return instance;}


    public static MetaTestData<String,String> testString(String expected, String actual){
        MetaTestData<String, String> mt = new MetaTestData<>();
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
            mt.setMessage(e.getMessage());
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
            mt.setMessage(e.getMessage());
        }
        return mt;
    }

}
