package com.buyalskaya.appliance.controller.command.impl;

import com.buyalskaya.appliance.controller.Request;
import com.buyalskaya.appliance.controller.Response;
import com.buyalskaya.appliance.controller.command.Command;
import com.buyalskaya.appliance.exception.ServiceException;
import com.buyalskaya.appliance.model.entity.Appliance;
import com.buyalskaya.appliance.model.service.ApplianceService;

import java.util.List;

public class FindAllByTagCommand implements Command {
    @Override
    public Response execute(Request request) {
        ApplianceService applianceService = new ApplianceService();
        Response response = new Response();
        try {
            List<Appliance> appliances = applianceService.findAllByTag(request);
            response.setCompletedSuccess(true);
            response.setAppliances(appliances);
        } catch (ServiceException ex) {
            String errorMessage = ex.getMessage();
            if (ex.getCause() != null) {
                errorMessage = errorMessage + ex.getCause().getMessage();
            }
            response.setMessage(errorMessage);
        }
        return response;
    }
}