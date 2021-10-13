package com.harshdev.kata.marsrover;

public class RoverState {
    private final Coordinate coordinate;
    private final Direction direction;

    public RoverState(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Coordinate coordinate() {
        return coordinate;
    }

    public Direction direction() {
        return direction;
    }
}
