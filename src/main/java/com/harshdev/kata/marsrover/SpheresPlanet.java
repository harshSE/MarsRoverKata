package com.harshdev.kata.marsrover;

import java.util.Collections;

public class SpheresPlanet implements Planet {
    private final Axis xAxis;
    private final Axis yAxis;
    private final Obstacles obstacles;

    public SpheresPlanet(Axis xAxis, Axis yAxis) {
        this(xAxis, yAxis, new Obstacles(Collections.emptyList()));
    }

    public SpheresPlanet(Axis xAxis, Axis yAxis, Obstacles obstacles) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.obstacles = obstacles;
    }

    @Override
    public Coordinate incrementY(Coordinate coordinate) {
        int newY = coordinate.yAxis() + 1;
        int newX = coordinate.xAxis();
        if(newY == yAxis.end()) {
            return incrementX(coordinate);
        }

        Coordinate newCoordinate = new Coordinate(newX, newY);
        checkObstacle(newCoordinate);

        return newCoordinate;
    }

    private void checkObstacle(Coordinate newCoordinate) {
        if(obstacles.hasAt(newCoordinate)){
            throw new ObstacleOccurredException(newCoordinate);
        }
    }

    @Override
    public Coordinate decrementY(Coordinate coordinate) {
        int newY = coordinate.yAxis() - 1;
        int newX = coordinate.xAxis();
        if(newY < yAxis.start()) {
            return decrementX(coordinate);
        }

        Coordinate newCoordinate = new Coordinate(newX, newY);
        checkObstacle(newCoordinate);

        return newCoordinate;
    }

    @Override
    public Coordinate incrementX(Coordinate coordinate) {
        int newX = coordinate.xAxis()+1;
        if(newX == xAxis.end()) {
            newX = 1;
        }
        Coordinate newCoordinate = new Coordinate(newX, coordinate.yAxis());
        checkObstacle(newCoordinate);
        return newCoordinate;
    }

    @Override
    public Coordinate decrementX(Coordinate coordinate) {
        int newX = coordinate.xAxis() - 1;
        if(newX < xAxis.start()) {
            newX = xAxis.end()-1;
        }

        Coordinate newCoordinate = new Coordinate(newX, coordinate.yAxis());
        checkObstacle(newCoordinate);
        return newCoordinate;
    }
}
