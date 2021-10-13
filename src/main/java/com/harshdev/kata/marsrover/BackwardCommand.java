package com.harshdev.kata.marsrover;

class BackwardCommand implements Command {
    @Override
    public RoverState execute(RoverState currentState) {
        Direction direction = currentState.direction();
        int x = currentState.coordinate().xAxis();
        int y = currentState.coordinate().yAxis();
        if (direction == Direction.NORTH) {
            y -= 1;
        } else if (direction == Direction.SOUTH) {
            y += 1;
        } else if (direction == Direction.EAST) {
            x -= 1;
        } else if (direction == Direction.WEST) {
            x += 1;
        }
        return new RoverState(new Coordinate(x, y), direction);
    }
}
