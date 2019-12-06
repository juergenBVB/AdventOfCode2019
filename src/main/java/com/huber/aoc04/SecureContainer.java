package com.huber.aoc04;

import com.huber.IAdventOfCode;

public class SecureContainer implements IAdventOfCode {
    private final Integer START = 402328;
    private final Integer END = 864247;

    public SecureContainer() {
    }

    public Integer partOne() {
        Integer counter = 0;
        for (Integer i = START; i <= END; i++) {
            if (checkPasswordOne(i.toString())) {
                counter++;
            }
        }

        return counter;
    }

    public Integer partTwo() {
        Integer counter = 0;
        for (Integer i = START; i <= END; i++) {
            if (checkPasswordTwo(i.toString())) {
                counter++;
            }
        }

        return counter;
    }

    public Boolean checkPasswordOne(final String input) {
        Boolean doubleChars = false;

        for (int i = 0; i < input.length() - 1; i++) {
            final char currentChar = input.charAt(i);
            final char followingChar = input.charAt(i + 1);

            if  (Integer.valueOf(currentChar) > Integer.valueOf(followingChar)) {
                return false;
            }

            // double char
            doubleChars = doubleChars || (currentChar == followingChar);
        }

        return doubleChars;
    }

    public Boolean checkPasswordTwo(final String input) {
        Boolean doubleChars = false;

        for (int i = 0; i < input.length() - 1; i++) {
            final char currentChar = input.charAt(i);
            final char followingChar = input.charAt(i + 1);

            if  (Integer.valueOf(currentChar) > Integer.valueOf(followingChar)) {
                return false;
            }

            char thirdChar = 0;
            char fourthChar = 0;

            if (i + 2 < input.length()) {
                thirdChar = input.charAt(i + 2);
            }
            if (i > 0) {
                fourthChar = input.charAt(i - 1);
            }

            // double char and not part of a group
            doubleChars = doubleChars || (currentChar == followingChar && followingChar != thirdChar && currentChar != fourthChar);
        }

        return doubleChars;
    }
}
