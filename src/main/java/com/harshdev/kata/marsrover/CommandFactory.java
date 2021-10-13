package com.harshdev.kata.marsrover;

import java.util.HashMap;

class CommandFactory {
    private HashMap<Character, Command> initialToCommand = new HashMap<>();
    private static final Command DO_NOTHING_COMMAND = new DoNothingCommand();

    CommandFactory() {
        initialToCommand.put('R', new RotateRightCommand());
        initialToCommand.put('L', new RotateLeftCommand());
        initialToCommand.put('F', new ForwardCommand());
        initialToCommand.put('B', new BackwardCommand());

    }

    public Command get(char initial) {
        return initialToCommand.getOrDefault(initial, DO_NOTHING_COMMAND);
    }

}
