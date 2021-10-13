package com.harshdev.kata.marsrover;

public class RoverState {
    private final Coordinate coordinate;
    private final DirectionEnum direction;

    public RoverState(Coordinate coordinate, DirectionEnum direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Coordinate coordinate() {
        return coordinate;
    }

    public DirectionEnum direction() {
        return direction;
    }

    public String serialize() {
        return String.format("%s:%s:%s", coordinate().xAxis(), coordinate().yAxis(), direction().value());
    }
}
