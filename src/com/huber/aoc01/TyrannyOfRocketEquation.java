package com.huber.aoc01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TyrannyOfRocketEquation {
    public TyrannyOfRocketEquation() {
    }

    public Integer partOne() throws IOException {
        final List<Integer> inputParameters = this.readInput();

        return inputParameters
                .stream()
                .mapToInt(this::requiredFuel)
                .sum();
    }

    public Integer partTwo() throws IOException {
        final List<Integer> inputParameters = this.readInput();

        return inputParameters
                .stream()
                .mapToInt(this::recursionRequiredFuel)
                .sum();
    }

    private List<Integer> readInput() throws IOException {
        File file = new File("C:\\dev\\projects\\AdventOfCode\\src\\com\\huber\\aoc01\\input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        final List<Integer> inputParameters = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            inputParameters.add(Integer.valueOf(line));
        }

        return inputParameters;
    }

    private Integer recursionRequiredFuel(final Integer input) {
        Integer output = 0;
        Integer result = input;
        do {
            result = requiredFuel(result);
            if (result > 0) {
                output += result;
            }
        } while (result > 0);

        return output;
    }

    private Integer requiredFuel(final Integer input) {
        return input / 3 - 2;
    }
}
