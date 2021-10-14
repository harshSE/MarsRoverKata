package com.harshdev.kata.marsrover;

public class MarsRover {
    private final CommandFactory commandFactory;
    private RoverState currentState;

    public MarsRover(Planet planet, Coordinate coordinate, DirectionEnum direction) {
        commandFactory = new CommandFactory(new DirectionProvider(planet));
        currentState = new RoverState(coordinate, direction);
    }

    public String execute(String commands) {
        for (char command : commands.toCharArray()) {
            try {
                execute(command);
            }catch (ObstacleOccurredException exception) {
                return "O:"+serializeState();
            }
        }
        return serializeState();
    }

    private String serializeState() {
        return currentState.serialize();
    }

    private void execute(char command) {
        currentState = commandFactory.get(command).execute(currentState);
    }

}
