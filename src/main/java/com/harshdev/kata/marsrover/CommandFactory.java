package com.harshdev.kata.marsrover;

import java.util.HashMap;

class CommandFactory {
    private HashMap<Character, Command> initialToCommand = new HashMap<>();
    private static final Command DO_NOTHING_COMMAND = new DoNothingCommand();

    CommandFactory(DirectionProvider directionProvider) {
        initialToCommand.put('R', new RotateRightCommand(directionProvider));
        initialToCommand.put('L', new RotateLeftCommand(directionProvider));
        initialToCommand.put('F', new ForwardCommand(directionProvider));
        initialToCommand.put('B', new BackwardCommand(directionProvider));

    }

    public Command get(char initial) {
        return initialToCommand.getOrDefault(initial, DO_NOTHING_COMMAND);
    }

}
