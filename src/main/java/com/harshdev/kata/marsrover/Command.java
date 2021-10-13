package com.harshdev.kata.marsrover;

interface Command {

    RoverState execute(RoverState currentState);
}
