package com.huber.aoc02;

public enum Opcode {
    ADD,
    MULTIPLY,
    END;

    public static Opcode ofValue(final Integer value) {
        switch (value) {
            case 1: return Opcode.ADD;
            case 2: return Opcode.MULTIPLY;
            case 99: return Opcode.END;
            default: throw new IllegalArgumentException();
        }
    }

}
