package com.harshdev.kata.marsrover;

class ForwardCommand implements Command {

    private DirectionProvider directionProvider;

    public ForwardCommand(DirectionProvider directionProvider) {
        this.directionProvider = directionProvider;
    }

    @Override
    public RoverState execute(RoverState currentState) {
        DirectionEnum direction = currentState.direction();
        return new RoverState(directionProvider.direction(direction).moveForward(currentState.coordinate()), direction);
    }


}
