package com.harshdev.kata.marsrover;

public class MarsRover {

    private Planet planet;
    private final CommandFactory commandFactory;
    private RoverState currentState;

    public MarsRover(Planet planet, Coordinate coordinate, DirectionEnum direction) {
        this.planet = planet;
        commandFactory = new CommandFactory(new DirectionProvider(planet));
        currentState = new RoverState(coordinate, direction);
    }

    public MarsRover(int x, int y, char direction) {
        this(new SpheresPlanet(
                        new Axis(Integer.MIN_VALUE, Integer.MIN_VALUE),
                        new Axis(Integer.MIN_VALUE, Integer.MIN_VALUE)
                ),
                new Coordinate(x, y),
                DirectionEnum.from(direction));
        currentState = new RoverState(new Coordinate(x, y), DirectionEnum.from(direction));
    }

    public String execute(String commands) {
        commands.chars().forEach(command -> execute((char) command));
        return serializeState();
    }

    private String serializeState() {
        return currentState.serialize();
    }

    private void execute(char command) {
        currentState = commandFactory.get(command).execute(currentState);
    }

}
