package com.harshdev.kata.marsrover;

public class SouthDirection implements Direction {

    private Planet planet;

    public SouthDirection(Planet planet) {
        this.planet = planet;
    }

    @Override
    public Coordinate moveForward(Coordinate coordinate) {
        return planet.decrementY(coordinate);
    }

    @Override
    public Coordinate moveBackward(Coordinate coordinate) {
        return planet.incrementY(coordinate);
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
