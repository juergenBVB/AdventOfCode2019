package com.huber.aoc01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
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
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("aoc01/input.txt");

        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

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
