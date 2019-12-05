package com.huber.aoc05;

import java.util.ArrayList;
import java.util.List;

public class Sunny {
    private final static List<Integer> INPUT_PARAMETERS = List.of(3,225,1,225,6,6,1100,1,238,225,104,0,1102,35,92,225,1101,25,55,225,1102,47,36,225,1102,17,35,225,1,165,18,224,1001,224,-106,224,4,224,102,8,223,223,1001,224,3,224,1,223,224,223,1101,68,23,224,101,-91,224,224,4,224,102,8,223,223,101,1,224,224,1,223,224,223,2,217,13,224,1001,224,-1890,224,4,224,102,8,223,223,1001,224,6,224,1,224,223,223,1102,69,77,224,1001,224,-5313,224,4,224,1002,223,8,223,101,2,224,224,1,224,223,223,102,50,22,224,101,-1800,224,224,4,224,1002,223,8,223,1001,224,5,224,1,224,223,223,1102,89,32,225,1001,26,60,224,1001,224,-95,224,4,224,102,8,223,223,101,2,224,224,1,223,224,223,1102,51,79,225,1102,65,30,225,1002,170,86,224,101,-2580,224,224,4,224,102,8,223,223,1001,224,6,224,1,223,224,223,101,39,139,224,1001,224,-128,224,4,224,102,8,223,223,101,3,224,224,1,223,224,223,1102,54,93,225,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,1008,677,677,224,1002,223,2,223,1005,224,329,101,1,223,223,7,677,677,224,102,2,223,223,1006,224,344,101,1,223,223,108,677,677,224,1002,223,2,223,1006,224,359,1001,223,1,223,7,677,226,224,1002,223,2,223,1005,224,374,1001,223,1,223,1107,677,226,224,1002,223,2,223,1005,224,389,1001,223,1,223,107,226,677,224,102,2,223,223,1005,224,404,1001,223,1,223,1108,226,677,224,1002,223,2,223,1006,224,419,101,1,223,223,107,226,226,224,102,2,223,223,1005,224,434,1001,223,1,223,108,677,226,224,1002,223,2,223,1006,224,449,101,1,223,223,108,226,226,224,102,2,223,223,1006,224,464,1001,223,1,223,1007,226,226,224,1002,223,2,223,1005,224,479,101,1,223,223,8,677,226,224,1002,223,2,223,1006,224,494,101,1,223,223,1007,226,677,224,102,2,223,223,1006,224,509,101,1,223,223,7,226,677,224,1002,223,2,223,1005,224,524,101,1,223,223,107,677,677,224,102,2,223,223,1005,224,539,101,1,223,223,1008,677,226,224,1002,223,2,223,1005,224,554,1001,223,1,223,1008,226,226,224,1002,223,2,223,1006,224,569,1001,223,1,223,1108,226,226,224,102,2,223,223,1005,224,584,101,1,223,223,1107,226,677,224,1002,223,2,223,1005,224,599,1001,223,1,223,8,226,677,224,1002,223,2,223,1006,224,614,1001,223,1,223,1108,677,226,224,102,2,223,223,1005,224,629,1001,223,1,223,8,226,226,224,1002,223,2,223,1005,224,644,1001,223,1,223,1107,677,677,224,1002,223,2,223,1005,224,659,1001,223,1,223,1007,677,677,224,1002,223,2,223,1005,224,674,101,1,223,223,4,223,99,226);

    public Sunny() {
    }

    public Integer partOne() {
        return this.doCalculation(1);
    }

    public Integer partTwo() {
        return this.doCalculation(5);
    }

    private Integer doCalculation(final Integer input) {
        List<Integer> list = new ArrayList<>(INPUT_PARAMETERS);

        Integer currentIndex = 0;
        Boolean endReached = false;
        Integer storedValue = input;

        while (!endReached) {
            final Instruction instruction = Instruction.ofValue(list.get(currentIndex).toString());

            switch (instruction.getOpcode()) {
                case ADD: {
                    list = this.doAddCalculation(currentIndex, instruction.getParameterModes(), list);
                    currentIndex += instruction.getOpcode().getParameterCount() + 1;
                    break;
                }
                case MULTIPLY: {
                    list = this.doMultiplyCalculation(currentIndex, instruction.getParameterModes(), list);
                    currentIndex += instruction.getOpcode().getParameterCount() + 1;
                    break;
                }
                case STORE: {
                    list = this.doStoreCalculation(currentIndex, storedValue, list);
                    currentIndex += instruction.getOpcode().getParameterCount() + 1;
                    break;
                }
                case GET: {
                    storedValue = this.doGetCalculation(currentIndex, instruction.getParameterModes(), list);
                    currentIndex += instruction.getOpcode().getParameterCount() + 1;
                    break;
                }
                case JUMP_IF_TRUE: {
                    currentIndex = this.doJumpIfTrueCalculation(currentIndex, instruction.getParameterModes(), list);
                    break;
                }
                case JUMP_IF_FALSE: {
                    currentIndex = this.doJumpIfFalseCalculation(currentIndex, instruction.getParameterModes(), list);
                    break;
                }
                case LESS_THAN: {
                    list = this.doLessThanCalculation(currentIndex, instruction.getParameterModes(), list);
                    currentIndex += instruction.getOpcode().getParameterCount() + 1;
                    break;
                }
                case EQUALS: {
                    list = this.doEqualsCalculation(currentIndex, instruction.getParameterModes(), list);
                    currentIndex += instruction.getOpcode().getParameterCount() + 1;
                    break;
                }
                case END: {
                    endReached = true;
                    break;
                }
            }
        }

        return storedValue;
    }

    private List<Integer> doMultiplyCalculation(final Integer currentIndex, final List<ParameterMode> parameterModes, final List<Integer> list) {
        final Integer firstValue = parameterModes.get(0) == ParameterMode.POSITION_MODE ? list.get(list.get(currentIndex + 1)) : list.get(currentIndex + 1);
        final Integer secondValue = parameterModes.get(1) == ParameterMode.POSITION_MODE ? list.get(list.get(currentIndex + 2)) : list.get(currentIndex + 2);
        final Integer targetPosition = list.get(currentIndex + 3);

        list.set(targetPosition, firstValue * secondValue);

        return list;
    }

    private Integer doJumpIfTrueCalculation(final Integer currentIndex, final List<ParameterMode> parameterModes, final List<Integer> list) {
        final Integer firstValue = parameterModes.get(0) == ParameterMode.POSITION_MODE ? list.get(list.get(currentIndex + 1)) : list.get(currentIndex + 1);

        if (firstValue != 0) {
            return parameterModes.get(1) == ParameterMode.POSITION_MODE ? list.get(list.get(currentIndex + 2)) : list.get(currentIndex + 2);

        } else {
            return currentIndex + 3;
        }
    }

    private List<Integer> doLessThanCalculation(final Integer currentIndex, final List<ParameterMode> parameterModes, final List<Integer> list) {
        final Integer firstValue = parameterModes.get(0) == ParameterMode.POSITION_MODE ? list.get(list.get(currentIndex + 1)) : list.get(currentIndex + 1);
        final Integer secondValue = parameterModes.get(1) == ParameterMode.POSITION_MODE ? list.get(list.get(currentIndex + 2)) : list.get(currentIndex + 2);
        final Integer targetPosition = list.get(currentIndex + 3);

        list.set(targetPosition, firstValue < secondValue ? 1 : 0);

        return list;
    }

    private List<Integer> doEqualsCalculation(final Integer currentIndex, final List<ParameterMode> parameterModes, final List<Integer> list) {
        final Integer firstValue = parameterModes.get(0) == ParameterMode.POSITION_MODE ? list.get(list.get(currentIndex + 1)) : list.get(currentIndex + 1);
        final Integer secondValue = parameterModes.get(1) == ParameterMode.POSITION_MODE ? list.get(list.get(currentIndex + 2)) : list.get(currentIndex + 2);
        final Integer targetPosition = list.get(currentIndex + 3);

        list.set(targetPosition, firstValue.equals(secondValue) ? 1 : 0);

        return list;
    }

    private Integer doJumpIfFalseCalculation(final Integer currentIndex, final List<ParameterMode> parameterModes, final List<Integer> list) {
        final Integer firstValue = parameterModes.get(0) == ParameterMode.POSITION_MODE ? list.get(list.get(currentIndex + 1)) : list.get(currentIndex + 1);

        if (firstValue == 0) {
            return parameterModes.get(1) == ParameterMode.POSITION_MODE ? list.get(list.get(currentIndex + 2)) : list.get(currentIndex + 2);

        } else {
            return currentIndex + 3;
        }
    }

    private List<Integer> doAddCalculation(final Integer currentIndex, final List<ParameterMode> parameterModes, final List<Integer> list) {
        final Integer firstValue = parameterModes.get(0) == ParameterMode.POSITION_MODE ? list.get(list.get(currentIndex + 1)) : list.get(currentIndex + 1);
        final Integer secondValue = parameterModes.get(1) == ParameterMode.POSITION_MODE ? list.get(list.get(currentIndex + 2)) : list.get(currentIndex + 2);
        final Integer targetPosition = list.get(currentIndex + 3);

        list.set(targetPosition, firstValue + secondValue);

        return list;
    }

    private List<Integer> doStoreCalculation(final Integer currentIndex, final Integer inputValue, final List<Integer> list) {
        final Integer targetPosition = list.get(currentIndex + 1);

        list.set(targetPosition, inputValue);

        return list;
    }

    private Integer doGetCalculation(final Integer currentIndex, final List<ParameterMode> parameterModes, final List<Integer> list) {
        return parameterModes.get(0) == ParameterMode.POSITION_MODE ? list.get(list.get(currentIndex + 1)) : list.get(currentIndex + 1);
    }
}
