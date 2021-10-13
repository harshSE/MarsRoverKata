package com.harshdev.kata.marsrover;

public class NorthDirection implements Direction {

    private Planet planet;

    public NorthDirection(Planet planet) {
        this.planet = planet;
    }

    @Override
    public Coordinate moveForward(Coordinate coordinate) {
        return planet.incrementY(coordinate);
    }

    @Override
    public Coordinate moveBackward(Coordinate coordinate) {
        return new Coordinate(coordinate.xAxis(), coordinate.yAxis() - 1);
    }

    @Override
    public DirectionEnum rotateRight() {
        return DirectionEnum.EAST;
    }

    @Override
    public DirectionEnum rotateLeft() {
        return DirectionEnum.WEST;
    }
}
