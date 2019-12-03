package com.huber.aoc03;

public class Instruction {
    private Direction direction;

    private Integer length;

    public Instruction(Direction direction, Integer length) {
        this.direction = direction;
        this.length = length;
    }

    public Direction getDirection() {
        return direction;
    }

    public Integer getLength() {
        return length;
    }
}
