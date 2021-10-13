package com.harshdev.kata.marsrover;

class RotateLeftCommand implements Command {

    private DirectionProvider directionProvider;

    public RotateLeftCommand(DirectionProvider directionProvider) {
        this.directionProvider = directionProvider;
    }

    @Override
    public RoverState execute(RoverState currentState) {
        DirectionEnum direction = currentState.direction();
        return new RoverState(currentState.coordinate(), directionProvider.direction(direction).rotateLeft());
    }
}
