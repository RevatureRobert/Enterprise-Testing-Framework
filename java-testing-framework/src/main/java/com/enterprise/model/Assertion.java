package com.enterprise.model;

public class Assertion <E,A>{
    private E expected;
    private A actual;
    private Status status;

    public E getExpected() {
        return expected;
    }

    public void setExpected(E expected) {
        this.expected = expected;
    }

    public A getActual() {
        return actual;
    }

    public void setActual(A actual) {
        this.actual = actual;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Assertion() {
        this.expected = null;
        this.actual = null;
        this.status = Status.NEVER_RAN;
    }

    public Assertion(E expected, A actual, Status status) {
        this.expected = expected;
        this.actual = actual;
        this.status = status;
    }
}
