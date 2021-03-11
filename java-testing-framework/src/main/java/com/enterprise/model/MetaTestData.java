package com.enterprise.model;

import java.time.LocalTime;

public class MetaTestData<T,K> {
    Status status;
    T expected;
    K actual;
    String message;
    Throwable badStuff;

    /*
        The stopwatch class should provide this information
     */
    LocalTime elapsedRunTime;


    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("Test Results: ");
        tmp.append("Status: ");
        tmp.append(status);
        tmp.append("\n");
        tmp.append("Expected: ");
        tmp.append(expected);
        tmp.append('\n');
        tmp.append("Actual: ");
        tmp.append(actual);
        tmp.append('\n');
        if (message != null) {
            tmp.append("Message: ");
            tmp.append(message);
            tmp.append("\n");
        }
        tmp.append("ElapsedRunTime: ");
        tmp.append(elapsedRunTime);
        tmp.append("\n");


        return tmp.toString();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public T getExpected() {
        return expected;
    }

    public void setExpected(T expected) {
        this.expected = expected;
    }

    public K getActual() {
        return actual;
    }

    public void setActual(K actual) {
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
        this.status = Status.NEVER_RAN;

    }

    public MetaTestData(Status status, T expected, K actual, String message, Throwable badStuff, LocalTime elapsedRunTime) {
        this.status = status;
        this.expected = expected;
        this.actual = actual;
        this.message = message;
        this.badStuff = badStuff;
        this.elapsedRunTime = elapsedRunTime;
    }
}
