package com.huber;

import com.huber.aoc03.CrossedWires;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(new Timestamp(new Date().getTime()) + " ---- Starting calculation -----");

        final CrossedWires crossedWires = new CrossedWires();

        // calculate first Result
        final Integer firstResult = crossedWires.partOne();
        final Integer secondResult = crossedWires.partTwo();

        // output
        System.out.println(String.format("First result: %d, Second result: %d", firstResult, secondResult));
        System.out.println(new Timestamp(new Date().getTime()) + " ---- Finished calculation -----");
    }


}
