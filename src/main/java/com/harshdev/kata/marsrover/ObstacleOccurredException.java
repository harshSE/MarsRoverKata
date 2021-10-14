package com.harshdev.kata.marsrover;

public class ObstacleOccurredException extends RuntimeException {

    private final Coordinate coordinate;

    public ObstacleOccurredException(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate coordinate() {
        return coordinate;
    }
}
