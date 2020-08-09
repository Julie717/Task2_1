package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.AbstractFactory;
import com.buyalskaya.appliance.model.entity.Appliance;
import com.buyalskaya.appliance.model.entity.ApplianceParameter;
import com.buyalskaya.appliance.model.entity.FilterType;
import com.buyalskaya.appliance.model.entity.impl.VacuumCleaner;

import java.util.Map;

public class VacuumCleanerFactory implements AbstractFactory {
    @Override
    public Appliance createAppliance(Map<ApplianceParameter, String> parameters) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        for (ApplianceParameter parameter : parameters.keySet()) {
            switch (parameter) {
                case POWER_CONSUMPTION:
                    double powerConsumption = Double.parseDouble(parameters.get(parameter));
                    vacuumCleaner.setPowerConsumption(powerConsumption);
                    break;
                case FILTER_TYPE:
                    FilterType filterType = FilterType.valueOf(parameters.get(parameter).toUpperCase());
                    vacuumCleaner.setFilterType(filterType);
                    break;
                case BAG_TYPE:
                    vacuumCleaner.setBagType(parameters.get(parameter));
                    break;
                case WAND_TYPE:
                    vacuumCleaner.setWandType(parameters.get(parameter));
                    break;
                case MOTOR_SPEED_REGULATION:
                    double motorSpeedRegulation = Double.parseDouble(parameters.get(parameter));
                    vacuumCleaner.setMotorSpeedRegulation(motorSpeedRegulation);
                    break;
                case CLEANING_WIDTH:
                    double cleaningWidth = Double.parseDouble(parameters.get(parameter));
                    vacuumCleaner.setCleaningWidth(cleaningWidth);
                    break;
            }
        }
        return vacuumCleaner;
    }
}