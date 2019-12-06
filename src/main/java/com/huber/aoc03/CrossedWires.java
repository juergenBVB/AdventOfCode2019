package com.huber.aoc03;

import com.huber.IAdventOfCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrossedWires implements IAdventOfCode {
    private final String INSTRUCTION_REGEX = "([LURD])(\\d+)";

    public CrossedWires() {
    }

    public Integer partTwo() throws IOException {
        final List<List<Instruction>> instructions = this.readInput();


        final List<Point> crossPoints = this.calculateCrossPoints(instructions);

        List<Integer> distances = new ArrayList<>();

        for (final Point crossPoint : crossPoints) {
            Integer result = 0;
            for (final List<Instruction> instructionList : instructions) {
                result += this.calculateDistanceToPoint(instructionList, crossPoint);
            }

            distances.add(result);
        }

        return distances.stream().min(Integer::compareTo).orElseThrow(IllegalStateException::new);
    }

    private Integer calculateDistanceToPoint(List<Instruction> instructionList, Point lowestDistancePoint) {
        Integer result = 0;

        Point currentPoint = new Point(0, 0);

        for (final Instruction instruction : instructionList) {
            switch (instruction.getDirection()) {
                case LEFT: {
                    for (int i = 0; i < instruction.getLength(); i++) {
                        result++;
                        currentPoint = new Point(currentPoint.getX() - 1, currentPoint.getY());
                        if (currentPoint.equals(lowestDistancePoint)) {
                            return result;
                        }
                    }
                    break;
                }
                case UP: {
                    for (int i = 0; i < instruction.getLength(); i++) {
                        result++;
                        currentPoint = new Point(currentPoint.getX(), currentPoint.getY() + 1);
                        if (currentPoint.equals(lowestDistancePoint)) {
                            return result;
                        }
                    }
                    break;
                }
                case RIGHT: {
                    for (int i = 0; i < instruction.getLength(); i++) {
                        result++;
                        currentPoint = new Point(currentPoint.getX() + 1, currentPoint.getY());
                        if (currentPoint.equals(lowestDistancePoint)) {
                            return result;
                        }
                    }
                    break;
                }
                case DOWN: {
                    for (int i = 0; i < instruction.getLength(); i++) {
                        result++;
                        currentPoint = new Point(currentPoint.getX(), currentPoint.getY() - 1);
                        if (currentPoint.equals(lowestDistancePoint)) {
                            return result;
                        }
                    }
                }
            }
        }

        return result;
    }

    public Integer partOne() throws IOException {
        final List<List<Instruction>> instructions = this.readInput();

        final List<Point> crossPoints = this.calculateCrossPoints(instructions);

        // calculate lowest distance
        return crossPoints.stream()
                .mapToInt(Point::getDistance)
                .min()
                .orElseThrow(IllegalStateException::new);
    }

    private List<Point> calculateCrossPoints(List<List<Instruction>> instructions) throws IOException {
        final List<List<Point>> allPoints = new ArrayList<>();

        // fill with points hit
        for (final List<Instruction> instructionList : instructions) {
            allPoints.add(this.calculatePoints(instructionList));
        }

        // compare coordinates
        return this.compareCoordinates(allPoints);
    }

    private List<Point> compareCoordinates(List<List<Point>> allPoints) {
        final List<Point> crossPoints = new ArrayList<>();

        for (int i = 0; i < allPoints.size(); i++) {
            final List<Point> currentPoints = allPoints.get(i);

            final List<Point> otherPoints = new ArrayList<>();
            for (int j = i + 1; j < allPoints.size(); j++) {
                otherPoints.addAll(allPoints.get(j));
            }

            currentPoints.retainAll(otherPoints);
            crossPoints.addAll(currentPoints);
        }

        return crossPoints;
    }

    private List<Point> calculatePoints(List<Instruction> instructionList) {
        final List<Point> points = new ArrayList<>();

        Point currentPoint = new Point(0, 0);

        for (final Instruction instruction : instructionList) {
            switch (instruction.getDirection()) {
                case LEFT: {
                    for (int i = 0; i < instruction.getLength(); i++) {
                        currentPoint = new Point(currentPoint.getX() - 1, currentPoint.getY());
                        points.add(currentPoint);
                    }
                    break;
                }
                case UP: {
                    for (int i = 0; i < instruction.getLength(); i++) {
                        currentPoint = new Point(currentPoint.getX(), currentPoint.getY() + 1);
                        points.add(currentPoint);
                    }
                    break;
                }
                case RIGHT: {
                    for (int i = 0; i < instruction.getLength(); i++) {
                        currentPoint = new Point(currentPoint.getX() + 1, currentPoint.getY());
                        points.add(currentPoint);
                    }
                    break;
                }
                case DOWN: {
                    for (int i = 0; i < instruction.getLength(); i++) {
                        currentPoint = new Point(currentPoint.getX(), currentPoint.getY() - 1);
                        points.add(currentPoint);
                    }
                }
            }
        }

        return points;
    }

    private List<List<Instruction>> readInput() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("aoc03/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        String line;
        final List<List<Instruction>> inputParameters = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            final String[] instructionInput = line.split(",");
            final  List<Instruction> instructions = new ArrayList<>();

            for (final String instruction : instructionInput) {
                final Pattern pattern = Pattern.compile(INSTRUCTION_REGEX, Pattern.MULTILINE);
                final Matcher matcher = pattern.matcher(instruction);

                while (matcher.find()) {
                    final Direction direction = Direction.ofValue(matcher.group(1));
                    final Integer length = Integer.valueOf(matcher.group(2));

                    instructions.add(new Instruction(direction, length));
                }
            }

            inputParameters.add(instructions);
        }

        return inputParameters;
    }
}
