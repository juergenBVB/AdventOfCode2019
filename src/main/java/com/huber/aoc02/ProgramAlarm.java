package com.huber.aoc02;

import com.huber.IAdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class ProgramAlarm implements IAdventOfCode {
    private final static List<Integer> inputParameters = List.of(1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,10,19,1,19,5,23,2,23,9,27,1,5,27,31,1,9,31,35,1,35,10,39,2,13,39,43,1,43,9,47,1,47,9,51,1,6,51,55,1,13,55,59,1,59,13,63,1,13,63,67,1,6,67,71,1,71,13,75,2,10,75,79,1,13,79,83,1,83,10,87,2,9,87,91,1,6,91,95,1,9,95,99,2,99,10,103,1,103,5,107,2,6,107,111,1,111,6,115,1,9,115,119,1,9,119,123,2,10,123,127,1,127,5,131,2,6,131,135,1,135,5,139,1,9,139,143,2,143,13,147,1,9,147,151,1,151,2,155,1,9,155,0,99,2,0,14,0);

    public ProgramAlarm() {
    }

    public Integer partOne() {
        return this.doCalculation(12, 2);
    }

    public Integer partTwo() {
        for (int noun = 0; noun <= 99; noun++) {
            for (int verb = 0; verb < 99; verb++) {
                final Integer result = this.doCalculation(noun, verb);
                if (result == 19690720) {
                    return 100 * noun + verb;
                }
            }
        }

        return 0;
    }

    private Integer doCalculation(final Integer noun, final Integer verb) {
        List<Integer> list = new ArrayList<>(ProgramAlarm.inputParameters);
        list.set(1, noun);
        list.set(2, verb);

        Integer currentIndex = 0;
        Boolean endReached = false;
        while (!endReached) {
            final Opcode currentOp = Opcode.ofValue(list.get(currentIndex));

            switch (currentOp) {
                case ADD: list = this.doAddCalculation(currentIndex, list); break;
                case MULTIPLY: list = this.doMultiplyCalculation(currentIndex, list); break;
                case END: endReached = true; break;
            }
            currentIndex += 4;
        }

        return list.get(0);
    }

    private List<Integer> doMultiplyCalculation(final Integer currentIndex, final List<Integer> list) {
        final Integer firstValue = list.get(list.get(currentIndex + 1));
        final Integer secondValue = list.get(list.get(currentIndex + 2));
        final Integer targetPosition = list.get(currentIndex + 3);

        list.set(targetPosition, firstValue * secondValue);

        return list;
    }

    private List<Integer> doAddCalculation(final Integer currentIndex, final List<Integer> list) {
        final Integer firstValue = list.get(list.get(currentIndex + 1));
        final Integer secondValue = list.get(list.get(currentIndex + 2));
        final Integer targetPosition = list.get(currentIndex + 3);

        list.set(targetPosition, firstValue + secondValue);

        return list;
    }
}
