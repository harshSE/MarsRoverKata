package com.harshdev.kata.marsrover;

import java.util.HashSet;
import java.util.List;

public class Obstacles {
    private final HashSet<Coordinate> obstacles;

    public Obstacles(List<Coordinate> obstacles) {
        this.obstacles = new HashSet<>(obstacles);
    }

    public boolean hasAt(Coordinate newCoordinate) {
        return obstacles.contains(newCoordinate);
    }
}
