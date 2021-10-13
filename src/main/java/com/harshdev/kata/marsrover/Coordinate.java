package com.harshdev.kata.marsrover;

public class Coordinate {

    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int xAxis() {
        return x;
    }

    public int yAxis() {
        return y;
    }
}
