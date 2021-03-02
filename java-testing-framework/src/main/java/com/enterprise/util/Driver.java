package com.enterprise.util;
import com.enterprise.model.Stopwatch;
import com.enterprise.results.TestResultsAPI;

import java.util.Arrays;

// for testing testresultsAPI
public class Driver {

    public static void main(String[] args){
        Stopwatch s = new Stopwatch();
        s.startStopwatch();
        System.out.println("args = " );
        System.out.println("args = " );
        System.out.println("args = " );
        System.out.println("args = " );
        System.out.println("args = " );
        System.out.println("args = " );
        s.stopStopWatch();
        System.out.println(s.getElapsedTime());
    }
}
