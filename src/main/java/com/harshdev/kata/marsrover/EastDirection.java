package com.harshdev.kata.marsrover;

public class EastDirection implements Direction {

    private Planet planet;

    public EastDirection(Planet planet) {
        this.planet = planet;
    }

    @Override
    public Coordinate moveForward(Coordinate coordinate) {
        return planet.incrementX(coordinate);
    }

    @Override
    public Coordinate moveBackward(Coordinate coordinate) {
        return planet.decrementX(coordinate);
    }

    @Override
    public DirectionEnum rotateRight() {
        return DirectionEnum.SOUTH;
    }

    @Override
    public DirectionEnum rotateLeft() {
        return DirectionEnum.NORTH;
    }
}
