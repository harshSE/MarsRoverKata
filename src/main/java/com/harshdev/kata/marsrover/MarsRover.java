package com.harshdev.kata.marsrover;

public class MarsRover {
    private final CommandFactory commandFactory = new CommandFactory();
    private RoverState currentState;

    public MarsRover(int x, int y, char direction) {
        currentState = new RoverState(new Coordinate(x, y), Direction.from(direction));
    }

    public String execute(String commands) {
        commands.chars().forEach(command -> execute((char) command));
        return serializeState();
    }

    private String serializeState() {
        return String.format("%s:%s:%s", currentState.coordinate().xAxis(), currentState.coordinate().yAxis(), currentState.direction().value());
    }

    private void execute(char command) {
        currentState = commandFactory.get(command).execute(currentState);
    }

}
