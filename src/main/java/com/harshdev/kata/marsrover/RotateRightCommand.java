package com.harshdev.kata.marsrover;

class RotateRightCommand implements Command {

    @Override
    public RoverState execute(RoverState currentState) {
        return new RoverState(currentState.coordinate(), currentState.direction().rightDirection());
    }
}
