package com.buyalskaya.appliance.creator;

import com.buyalskaya.appliance.model.entity.Appliance;
import com.buyalskaya.appliance.model.entity.ApplianceParameter;

import java.util.Map;

public interface AbstractFactory {
    Appliance createAppliance(Map<ApplianceParameter, String> parameters);
}