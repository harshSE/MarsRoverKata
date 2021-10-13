package com.harshdev.kata.marsrover;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public enum Direction {
    SOUTH('S') {
        @Override
        public Direction rightDirection() {
            return WEST;
        }

        @Override
        public Direction leftDirection() {
            return EAST;
        }
    },
    NORTH('N'){
        @Override
        public Direction rightDirection() {
            return EAST;
        }

        @Override
        public Direction leftDirection() {
            return WEST;
        }
    },
    EAST('E') {
        @Override
        public Direction rightDirection() {
            return SOUTH;
        }

        @Override
        public Direction leftDirection() {
            return NORTH;
        }
    },
    WEST('W') {
        @Override
        public Direction rightDirection() {
            return NORTH;
        }

        @Override
        public Direction leftDirection() {
            return SOUTH;
        }
    },
    ;

    private final char value;

    Direction(char value) {
        this.value =  value;
    }

    private static Map<Character, Direction> initialToDirection;

    static {
        initialToDirection = Arrays.stream(Direction.values())
                .collect(toMap(direction1 -> direction1.value, Function.identity()));
    }

    public abstract Direction rightDirection();
    public abstract Direction leftDirection();


    public static Direction from(char direction) {
        return initialToDirection.get(direction);
    }

    public char value() {
        return value;
    }
}
