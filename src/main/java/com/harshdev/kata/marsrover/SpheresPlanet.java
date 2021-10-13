package com.harshdev.kata.marsrover;

public class SpheresPlanet implements Planet {
    private final Axis xAxis;
    private final Axis yAxis;

    public SpheresPlanet(Axis xAxis, Axis yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    @Override
    public Coordinate incrementY(Coordinate coordinate) {
        int newY = coordinate.yAxis() + 1;
        int newX = coordinate.xAxis();
        if(newY == yAxis.end()) {
            return incrementX(coordinate);
        }
        return new Coordinate(newX, newY);
    }

    @Override
    public Coordinate decrementY(Coordinate coordinate) {
        int newY = coordinate.yAxis() - 1;
        int newX = coordinate.xAxis();
        if(newY < yAxis.start()) {
            return decrementX(coordinate);
        }
        return new Coordinate(newX, newY);
    }

    @Override
    public Coordinate incrementX(Coordinate coordinate) {
        int newX = coordinate.xAxis()+1;
        if(newX == xAxis.end()) {
            newX = 1;
        }
        return new Coordinate(newX, coordinate.yAxis());
    }

    @Override
    public Coordinate decrementX(Coordinate coordinate) {
        int newX = coordinate.xAxis() - 1;
        if(newX < xAxis.start()) {
            newX = xAxis.end()-1;
        }
        return new Coordinate(newX, coordinate.yAxis());
    }
}
