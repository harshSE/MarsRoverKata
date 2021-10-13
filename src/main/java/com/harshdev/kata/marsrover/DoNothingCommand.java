package com.harshdev.kata.marsrover;

class DoNothingCommand implements Command {
    @Override
    public RoverState execute(RoverState currentState) {
        return currentState;
    }
}
