package com.huber;

import com.huber.aoc06.UniversalOrbitMap;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class AdventOfCode {

    public static void main(String[] args) throws IOException {
        System.out.println(new Timestamp(new Date().getTime()) + " ---- Starting calculation -----");

        final IAdventOfCode adventOfCode = new UniversalOrbitMap();

        final Integer firstResult = adventOfCode.partOne();
        final Integer secondResult = adventOfCode.partTwo();

        // output
        System.out.println(String.format("First result: %d, Second result: %d", firstResult, secondResult));
        System.out.println(new Timestamp(new Date().getTime()) + " ---- Finished calculation -----");
    }


}
