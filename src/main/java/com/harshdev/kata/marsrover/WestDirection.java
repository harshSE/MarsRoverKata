package com.harshdev.kata.marsrover;

public class WestDirection implements Direction {

    private Planet planet;

    public WestDirection(Planet planet) {
        this.planet = planet;
    }

    @Override
    public Coordinate moveForward(Coordinate coordinate) {
        return planet.decrementX(coordinate);
    }

    @Override
    public Coordinate moveBackward(Coordinate coordinate) {
        return planet.incrementX(coordinate);
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
