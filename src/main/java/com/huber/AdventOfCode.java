package com.huber;

import com.huber.aoc6.UniversalOrbitMap;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class AdventOfCode {

    public static void main(String[] args) throws IOException {
        System.out.println(new Timestamp(new Date().getTime()) + " ---- Starting calculation -----");

        final UniversalOrbitMap universalOrbitMap = new UniversalOrbitMap();

        final Integer firstResult = universalOrbitMap.partOne();
        final Integer secondResult = universalOrbitMap.partTwo();

        // output
        System.out.println(String.format("First result: %d, Second result: %d", firstResult, secondResult));
        System.out.println(new Timestamp(new Date().getTime()) + " ---- Finished calculation -----");
    }


}
