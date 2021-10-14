package com.harshdev.kata.marsrover;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class ObstaclesTest {

    @Test
    public void returnTrueWhenCoordinateIsObstacle() {
        Obstacles obstacles = new Obstacles(Collections.singletonList(new Coordinate(1, 1)));

        assert obstacles.hasAt(new Coordinate(1, 1));
        Assertions.assertThat(obstacles.hasAt(new Coordinate(1, 1))).isTrue();
    }

}