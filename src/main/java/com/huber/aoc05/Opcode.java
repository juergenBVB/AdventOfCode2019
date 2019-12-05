package com.huber.aoc05;

public enum Opcode {
    ADD(3),
    MULTIPLY(3),
    STORE(1),
    GET(1),
    JUMP_IF_TRUE(2),
    JUMP_IF_FALSE(2),
    LESS_THAN(3),
    EQUALS(3),
    END(0);

    private Integer parameterCount;

    Opcode(Integer parameterCount) {
        this.parameterCount = parameterCount;
    }

    public Integer getParameterCount() {
        return parameterCount;
    }

    public static Opcode ofValue(final Integer value) {
        switch (value) {
            case 1: return Opcode.ADD;
            case 2: return Opcode.MULTIPLY;
            case 3: return Opcode.STORE;
            case 4: return Opcode.GET;
            case 5: return Opcode.JUMP_IF_TRUE;
            case 6: return Opcode.JUMP_IF_FALSE;
            case 7: return Opcode.LESS_THAN;
            case 8: return Opcode.EQUALS;
            case 99: return Opcode.END;
            default: throw new IllegalArgumentException();
        }
    }

}
