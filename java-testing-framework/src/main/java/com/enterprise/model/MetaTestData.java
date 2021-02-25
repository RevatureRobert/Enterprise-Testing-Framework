package com.enterprise.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class MetaTestData {
    public enum status {
        PASSED,
        FAILED,
        ERRORED;
    }
    String expected;
    String actual;
    String message;
    Throwable badStuff;

    /*
        The stopwatch class should provide this information
     */
    LocalTime elapsedRunTime;




}
