package com.enterprise.model;

import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.*;

public class Stopwatch {
    LocalTime startedTICK;
    LocalTime endedTOCK;
    LocalTime elapsedTICKTOCK;

    public Stopwatch(){
    }

    public void startStopwatch()
    {
        this.startedTICK = LocalTime.now();
    };

    public void stopStopWatch()
    {
        this.endedTOCK = LocalTime.now();
        elapsedTICKTOCK = startedTICK.minusNanos(endedTOCK.toNanoOfDay());
    }

    public LocalTime getElapsedTime()
    {
        return elapsedTICKTOCK;
    }
}
