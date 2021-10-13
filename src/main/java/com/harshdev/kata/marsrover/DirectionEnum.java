package com.harshdev.kata.marsrover;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public enum DirectionEnum {
    SOUTH('S'),
    NORTH('N'),
    EAST('E'),
    WEST('W'),
    ;

    private final char value;

    DirectionEnum(char value) {
        this.value =  value;
    }

    private static Map<Character, DirectionEnum> initialToDirection;

    static {
        initialToDirection = Arrays.stream(DirectionEnum.values())
                .collect(toMap(direction1 -> direction1.value, Function.identity()));
    }


    public static DirectionEnum from(char direction) {
        return initialToDirection.get(direction);
    }

    public char value() {
        return value;
    }
}
