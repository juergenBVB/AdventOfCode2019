package com.huber.aoc05;

import java.util.ArrayList;
import java.util.List;

public class Instruction {
    private Opcode opcode;

    private List<ParameterMode> parameterModes;

    private Instruction(Opcode opcode, List<ParameterMode> parameterModes) {
        this.opcode = opcode;
        this.parameterModes = parameterModes;
    }

    public static Instruction ofValue(final String input) {
        final Opcode opcode;
        if (input.length() > 1) {
            opcode = Opcode.ofValue(Integer.parseInt(input.substring(input.length() - 2)));
        } else {
            opcode = Opcode.ofValue(Integer.parseInt(input));
        }

        final List<ParameterMode> parameterModes = new ArrayList<>();

        for (int i = input.length() - 3; i >= 0; i--) {
            parameterModes.add(String.valueOf(input.charAt(i)).equals("0") ? ParameterMode.POSITION_MODE : ParameterMode.IMMEDIATE_MODE);
        }

        for (int i = parameterModes.size() - 1; i <= 3; i++) {
            parameterModes.add(ParameterMode.POSITION_MODE);
        }

        return new Instruction(opcode, parameterModes);
    }

    public Opcode getOpcode() {
        return opcode;
    }

    public List<ParameterMode> getParameterModes() {
        return parameterModes;
    }
}
