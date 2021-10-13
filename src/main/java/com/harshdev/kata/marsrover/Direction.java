package com.harshdev.kata.marsrover;

public interface Direction {
    public static final Direction NORTH_DIRECTION = new NorthDirection(new SpheresPlanet(new Axis(Integer.MIN_VALUE, Integer.MAX_VALUE), new Axis(Integer.MIN_VALUE, Integer.MAX_VALUE)));
    public static final Direction SOUTH_DIRECTION = new SouthDirection(new SpheresPlanet(new Axis(Integer.MIN_VALUE, Integer.MAX_VALUE), new Axis(Integer.MIN_VALUE, Integer.MAX_VALUE)));
    public static final Direction EAST_DIRECTION = new EastDirection(new SpheresPlanet(new Axis(Integer.MIN_VALUE, Integer.MAX_VALUE), new Axis(Integer.MIN_VALUE, Integer.MAX_VALUE)));
    public static final Direction WEST_DIRECTION = new WestDirection(new SpheresPlanet(new Axis(Integer.MIN_VALUE, Integer.MAX_VALUE), new Axis(Integer.MIN_VALUE, Integer.MAX_VALUE)));

    public Coordinate moveForward(Coordinate coordinate);
    public Coordinate moveBackward(Coordinate coordinate);
    public DirectionEnum rotateRight();
    public DirectionEnum rotateLeft();

}
