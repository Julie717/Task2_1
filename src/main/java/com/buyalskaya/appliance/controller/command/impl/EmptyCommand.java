package com.buyalskaya.appliance.controller.command.impl;

import com.buyalskaya.appliance.controller.Request;
import com.buyalskaya.appliance.controller.Response;
import com.buyalskaya.appliance.controller.command.Command;

public class EmptyCommand implements Command {
    private static final String ERROR_MESSAGE = "Incorrect command";

    @Override
    public Response execute(Request request) {
        Response response = new Response();
        response.setCompletedSuccess(false);
        response.setMessage(ERROR_MESSAGE);
        return response;
    }
}