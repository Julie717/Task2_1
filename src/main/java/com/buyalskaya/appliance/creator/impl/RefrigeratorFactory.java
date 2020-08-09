package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.AbstractFactory;
import com.buyalskaya.appliance.model.entity.Appliance;
import com.buyalskaya.appliance.model.entity.ApplianceParameter;
import com.buyalskaya.appliance.model.entity.impl.Refrigerator;

import java.util.Map;

public class RefrigeratorFactory implements AbstractFactory {
    @Override
    public Appliance createAppliance(Map<ApplianceParameter, String> parameters) {
        Refrigerator refrigerator = new Refrigerator();
        for (ApplianceParameter parameter : parameters.keySet()) {
            switch (parameter) {
                case POWER_CONSUMPTION:
                    double powerConsumption = Double.parseDouble(parameters.get(parameter));
                    refrigerator.setPowerConsumption(powerConsumption);
                    break;
                case WEIGHT:
                    double weight = Double.parseDouble(parameters.get(parameter));
                    refrigerator.setWeight(weight);
                    break;
                case FREEZER_CAPACITY:
                    double freezerCapacity = Double.parseDouble(parameters.get(parameter));
                    refrigerator.setFreezerCapacity(freezerCapacity);
                    break;
                case OVERALL_CAPACITY:
                    double overallCapacity = Double.parseDouble(parameters.get(parameter));
                    refrigerator.setOverallCapacity(overallCapacity);
                    break;
                case HEIGHT:
                    double height = Double.parseDouble(parameters.get(parameter));
                    refrigerator.setHeight(height);
                    break;
                case WIDTH:
                    double width = Double.parseDouble(parameters.get(parameter));
                    refrigerator.setWidth(width);
                    break;
            }
        }
        return refrigerator;
    }
}