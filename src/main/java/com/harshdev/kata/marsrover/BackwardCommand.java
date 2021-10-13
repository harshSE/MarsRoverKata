package com.harshdev.kata.marsrover;

class BackwardCommand implements Command {
    private DirectionProvider directionProvider;

    public BackwardCommand(DirectionProvider directionProvider) {
        this.directionProvider = directionProvider;
    }

    @Override
    public RoverState execute(RoverState currentState) {
        DirectionEnum direction = currentState.direction();
        return new RoverState(directionProvider.direction(direction).moveBackward(currentState.coordinate()), direction);
    }
}
