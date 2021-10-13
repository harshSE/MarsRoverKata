package com.harshdev.kata.marsrover;

public class SouthDirection implements Direction {

    private Planet planet;

    public SouthDirection(Planet planet) {
        this.planet = planet;
    }

    @Override
    public Coordinate moveForward(Coordinate coordinate) {
        return new Coordinate(coordinate.xAxis(), coordinate.yAxis() - 1);
    }

    @Override
    public Coordinate moveBackward(Coordinate coordinate) {
        return new Coordinate(coordinate.xAxis(), coordinate.yAxis() + 1);
    }

    @Override
    public DirectionEnum rotateRight() {
        return DirectionEnum.WEST;
    }

    @Override
    public DirectionEnum rotateLeft() {
        return DirectionEnum.EAST;
    }
}
