package com.buyalskaya.appliance.controller;

import com.buyalskaya.appliance.controller.command.Command;

public class ApplianceController {
    private static ApplianceController instance;

    private ApplianceController() {
    }

    public static ApplianceController getInstance() {
        if (instance == null) {
            instance = new ApplianceController();
        }
        return instance;
    }

    public Response processRequest(Request request) {
        Command command = ActionProvider.defineCommand(request.getCommandName());
        Response response = command.execute(request);
        return response;
    }
}