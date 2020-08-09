package com.buyalskaya.appliance.controller.command;

import com.buyalskaya.appliance.controller.command.impl.FindAllByTagCommand;
import com.buyalskaya.appliance.controller.command.impl.FindAllCommand;
import com.buyalskaya.appliance.controller.command.impl.FindApplianceByTagCommand;
import com.buyalskaya.appliance.controller.command.impl.FindApplianceCommand;

public enum CommandType {
    FIND_ALL(new FindAllCommand()),
    FIND_APPLIANCE(new FindApplianceCommand()),
    FIND_ALL_BY_TAG(new FindAllByTagCommand()),
    FIND_APPLIANCE_BY_TAG(new FindApplianceByTagCommand());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}