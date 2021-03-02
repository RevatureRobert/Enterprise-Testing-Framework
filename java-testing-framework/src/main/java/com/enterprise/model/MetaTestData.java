package com.enterprise.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class MetaTestData {
    Status status;
    String expected;
    String actual;
    String message;
    Throwable badStuff;
    String methodName;

    /*
        The stopwatch class should provide this information
     */
    LocalTime elapsedRunTime;


    @Override
    public String toString() {
        return "MetaTestData{" +
            "status=" + status +
            ", expected='" + expected + '\'' +
            ", actual='" + actual + '\'' +
            ", message='" + message + '\'' +
            ", badStuff=" + badStuff +
            ", elapsedRunTime=" + elapsedRunTime +
            '}';
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getBadStuff() {
        return badStuff;
    }

    public void setBadStuff(Throwable badStuff) {
        this.badStuff = badStuff;
    }

    public LocalTime getElapsedRunTime() {
        return elapsedRunTime;
    }

    public void setElapsedRunTime(LocalTime elapsedRunTime) {
        this.elapsedRunTime = elapsedRunTime;
    }

    public MetaTestData() {
    }

    public MetaTestData(Status status, String expected, String actual, String message, Throwable badStuff, LocalTime elapsedRunTime) {
        this.status = status;
        this.expected = expected;
        this.actual = actual;
        this.message = message;
        this.badStuff = badStuff;
        this.elapsedRunTime = elapsedRunTime;
    }
}
