package com.huber.aoc06;

public class OrbitPlan {
    private String parentPlanet;

    private String childPlanet;

    public OrbitPlan(String parentPlanet, String childPlanet) {
        this.parentPlanet = parentPlanet;
        this.childPlanet = childPlanet;
    }

    public String getParentPlanet() {
        return parentPlanet;
    }

    public String getChildPlanet() {
        return childPlanet;
    }
}
