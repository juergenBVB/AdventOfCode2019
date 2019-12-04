package com.huber.aoc04;

public class SecureContainer {
    private final Integer START = 402328;
    private final Integer END = 864247;

    public SecureContainer() {
    }

    public Integer partOne() {
        Integer counter = 0;
        for (Integer i = START; i <= END; i++) {
            if (checkPassword(i.toString())) {
                counter++;
            }
        }

        return counter;
    }

    public Boolean checkPassword(final String input) {
        Boolean doubleChars = false;

        for (int i = 0; i < input.length() - 1; i++) {
            final char currentChar = input.charAt(i);
            final char followingChar = input.charAt(i + 1);

            if  (Integer.valueOf(currentChar) > Integer.valueOf(followingChar)) {
                return false;
            }

            doubleChars = doubleChars || currentChar == followingChar;
        }

        return doubleChars;
    }
}
