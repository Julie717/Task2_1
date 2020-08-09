package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.AbstractFactory;
import com.buyalskaya.appliance.model.entity.Appliance;
import com.buyalskaya.appliance.model.entity.ApplianceParameter;
import com.buyalskaya.appliance.model.entity.impl.Oven;

import java.util.Map;

public class OvenFactory implements AbstractFactory {
    @Override
    public Appliance createAppliance(Map<ApplianceParameter, String> parameters) {
        Oven oven = new Oven();
        for (ApplianceParameter parameter : parameters.keySet()) {
            switch (parameter) {
                case POWER_CONSUMPTION:
                    double powerConsumption = Double.parseDouble(parameters.get(parameter));
                    oven.setPowerConsumption(powerConsumption);
                    break;
                case WEIGHT:
                    double weight = Double.parseDouble(parameters.get(parameter));
                    oven.setWeight(weight);
                    break;
                case CAPACITY:
                    double capacity = Double.parseDouble(parameters.get(parameter));
                    oven.setCapacity(capacity);
                    break;
                case DEPTH:
                    double depth = Double.parseDouble(parameters.get(parameter));
                    oven.setDepth(depth);
                    break;
                case HEIGHT:
                    double height = Double.parseDouble(parameters.get(parameter));
                    oven.setHeight(height);
                    break;
                case WIDTH:
                    double width = Double.parseDouble(parameters.get(parameter));
                    oven.setWidth(width);
                    break;
            }
        }
        return oven;
    }
}