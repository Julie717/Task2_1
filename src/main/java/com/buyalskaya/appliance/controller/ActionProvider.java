package com.buyalskaya.appliance.controller;

import com.buyalskaya.appliance.controller.command.Command;
import com.buyalskaya.appliance.controller.command.CommandType;
import com.buyalskaya.appliance.controller.command.impl.EmptyCommand;

import java.util.Arrays;

public class ActionProvider {
    public static Command defineCommand(String commandName) {
        Command command = new EmptyCommand();
        if (commandName != null) {
            command = Arrays.stream(CommandType.values())
                    .filter(p -> p.name().equals(commandName.toUpperCase()))
                    .findFirst()
                    .map(CommandType::getCommand).orElse(command);
        }
        return command;
    }
}