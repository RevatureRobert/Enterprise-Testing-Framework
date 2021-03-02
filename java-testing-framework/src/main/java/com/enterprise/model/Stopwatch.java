package com.enterprise.model;

import java.time.LocalTime;

public class Stopwatch {
    LocalTime startedTICK;
    LocalTime endedTOCK;
    LocalTime elapsedTICKTOCK;

    Stopwatch myTimer = new Stopwatch();

    public Stopwatch(){
        startStopwatch();
    }


    public void startStopwatch()
    {
        this.startedTICK = LocalTime.now();
    };

    public void stopStopWatch()
    {
        this.endedTOCK = LocalTime.now();
    }

    public int getElapsedTime()
    {
        return this.endedTOCK.minus(this.startedTICK, );
    }
}
