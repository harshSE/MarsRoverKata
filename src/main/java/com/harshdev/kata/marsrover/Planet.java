package com.harshdev.kata.marsrover;

public interface Planet {

    Coordinate incrementY(Coordinate coordinate) throws ObstacleOccurredException;
    Coordinate decrementY(Coordinate coordinate);
    Coordinate incrementX(Coordinate coordinate);
    Coordinate decrementX(Coordinate coordinate);

}
