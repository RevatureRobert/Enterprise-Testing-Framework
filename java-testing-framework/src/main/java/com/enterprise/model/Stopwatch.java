package com.enterprise.model;

import java.time.LocalTime;

public class Stopwatch {
    private LocalTime startedTICK;
    private LocalTime endedTOCK;
    private LocalTime elapsedTICKTOCK;

    public Stopwatch(){
        elapsedTICKTOCK = LocalTime.MIN;
    }

    public void startStopwatch()
    {
        this.startedTICK = LocalTime.now();
    }

    public void stopStopWatch()
    {
        this.endedTOCK = LocalTime.now();
    }

    public LocalTime getElapsedTime()
    {
        elapsedTICKTOCK = endedTOCK.minusNanos(startedTICK.toNanoOfDay());
        //System.out.println("Elapsed time: " + elapsedTICKTOCK.getNano() + "  nano seconds");
        return elapsedTICKTOCK;
    }
}
