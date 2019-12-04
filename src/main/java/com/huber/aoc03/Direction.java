package com.huber.aoc03;

public enum Direction {
    LEFT,
    UP,
    RIGHT,
    DOWN;

    public static Direction ofValue(final String input) {
        switch (input) {
            case "L": return LEFT;
            case "U": return UP;
            case "R": return RIGHT;
            case "D": return DOWN;
            default: throw new IllegalArgumentException();
        }
    }
}
