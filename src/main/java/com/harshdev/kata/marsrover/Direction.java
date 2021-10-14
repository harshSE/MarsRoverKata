package com.harshdev.kata.marsrover;

public interface Direction {

    Coordinate moveForward(Coordinate coordinate);
    Coordinate moveBackward(Coordinate coordinate);
    DirectionEnum rotateRight();
    DirectionEnum rotateLeft();

}
