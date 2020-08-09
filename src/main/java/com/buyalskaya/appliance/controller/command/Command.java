package com.buyalskaya.appliance.controller.command;

import com.buyalskaya.appliance.controller.Request;
import com.buyalskaya.appliance.controller.Response;

public interface Command {
    Response execute(Request request);
}