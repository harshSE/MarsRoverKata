package com.harshdev.kata.marsrover;

public class Axis {
    private final int start;
    private final int end;

    public Axis(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int start() {
        return start;
    }

    public int end() {
        return end;
    }
}
