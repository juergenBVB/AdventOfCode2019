package com.huber;

import com.huber.aoc04.SecureContainer;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(new Timestamp(new Date().getTime()) + " ---- Starting calculation -----");

        final SecureContainer secureContainer = new SecureContainer();

        // calculate first Result
        final Integer firstResult = secureContainer.partOne();
        final Integer secondResult = secureContainer.partTwo();

        // output
        System.out.println(String.format("First result: %d, Second result: %d", firstResult, secondResult));
        System.out.println(new Timestamp(new Date().getTime()) + " ---- Finished calculation -----");
    }


}
