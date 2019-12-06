package com.huber.aoc06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniversalOrbitMap {
    private static final String ORBIT_REGEX = "(.+)\\)(.+)";

    private Tree<String> tree;

    public UniversalOrbitMap() throws IOException {
        this.tree = this.buildTree();
    }

    public Integer partOne() {
        return this.tree.getRoot().getChildren().stream().mapToInt(Node::countParents).sum();
    }

    public Integer partTwo() {
        // find YOU node
        final Node<String> you = this.tree.findNode("YOU");
        System.out.println("YOU found");

        // caculate distance to other node
        return you.distanceTo("SAN");
    }

    private Tree<String> buildTree() throws IOException {
        final List<OrbitPlan> input = this.readInput();

        final Tree<String> tree = new Tree<>("COM");

        while (!input.isEmpty()) {
            for (final OrbitPlan currentPlan : input) {
                final Node<String> foundNode = tree.findNode(currentPlan.getParentPlanet());
                if (foundNode == null) {
                    continue;
                }

                foundNode.getChildren().add(new Node<>(currentPlan.getChildPlanet(), foundNode, new ArrayList<>()));
                input.remove(currentPlan);
                System.out.println(String.format("Node applied to tree, '%d' input parameters remaining...", input.size()));
                break;
            }
        }

        return tree;
    }

    private List<OrbitPlan> readInput() throws IOException {
        File file = new File("C:\\dev\\projects\\AdventOfCode\\src\\main\\resources\\aoc06\\input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        final List<OrbitPlan> inputParameters = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            final Pattern pattern = Pattern.compile(ORBIT_REGEX, Pattern.MULTILINE);
            final Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                final String parentPlanet = matcher.group(1);
                final String childPlanet = matcher.group(2);
                inputParameters.add(new OrbitPlan(parentPlanet, childPlanet));
            }
        }

        return inputParameters;
    }
}
