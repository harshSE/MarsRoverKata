package com.harshdev.kata.marsrover;

class RotateLeftCommand implements Command {
    @Override
    public RoverState execute(RoverState currentState) {
        return new RoverState(currentState.coordinate(), currentState.direction().leftDirection());
    }
}
