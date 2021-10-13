package com.harshdev.kata.marsrover;

public class WestDirection implements Direction {

    private Planet planet;

    public WestDirection(Planet planet) {
        this.planet = planet;
    }

    @Override
    public Coordinate moveForward(Coordinate coordinate) {
        return new Coordinate(coordinate.xAxis() - 1, coordinate.yAxis());
    }

    @Override
    public Coordinate moveBackward(Coordinate coordinate) {
        return new Coordinate(coordinate.xAxis() + 1, coordinate.yAxis());
    }

    @Override
    public DirectionEnum rotateRight() {
        return DirectionEnum.NORTH;
    }

    @Override
    public DirectionEnum rotateLeft() {
        return DirectionEnum.SOUTH;
    }
}
