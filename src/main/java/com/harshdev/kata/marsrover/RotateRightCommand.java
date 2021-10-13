package com.harshdev.kata.marsrover;

class RotateRightCommand implements Command {

    private final DirectionProvider directionProvider;

    public RotateRightCommand(DirectionProvider directionProvider) {
        this.directionProvider = directionProvider;
    }

    @Override
    public RoverState execute(RoverState currentState) {
        DirectionEnum direction = currentState.direction();
        return new RoverState(currentState.coordinate(), directionProvider.direction(direction).rotateRight());
    }
}
