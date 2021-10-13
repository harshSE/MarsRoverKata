package com.harshdev.kata.marsrover;

import java.util.EnumMap;

import static com.harshdev.kata.marsrover.DirectionEnum.EAST;
import static com.harshdev.kata.marsrover.DirectionEnum.NORTH;
import static com.harshdev.kata.marsrover.DirectionEnum.SOUTH;
import static com.harshdev.kata.marsrover.DirectionEnum.WEST;

public class DirectionProvider {

    private EnumMap<DirectionEnum, Direction> directionToCommand = new EnumMap<>(DirectionEnum.class);

    public DirectionProvider(Planet planet) {
        directionToCommand.put(NORTH, new NorthDirection(planet));
        directionToCommand.put(SOUTH, new SouthDirection(planet));
        directionToCommand.put(EAST, new EastDirection(planet));
        directionToCommand.put(WEST, new WestDirection(planet));
    }

    public Direction direction(DirectionEnum directionEnum) {
        return directionToCommand.get(directionEnum);
    }

}
