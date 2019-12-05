package com.huber;

import com.huber.aoc04.SecureContainer;
import com.huber.aoc05.Sunny;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class AdventOfCode {

    public static void main(String[] args) throws IOException {
        System.out.println(new Timestamp(new Date().getTime()) + " ---- Starting calculation -----");

        final Sunny sunny = new Sunny();

        final Integer firstResult = sunny.partOne();
        final Integer secondResult = sunny.partTwo();

        // output
        System.out.println(String.format("First result: %d, Second result: %d", firstResult, secondResult));
        System.out.println(new Timestamp(new Date().getTime()) + " ---- Finished calculation -----");
    }


}
