package com.buyalskaya.appliance.creator;

import com.buyalskaya.appliance.creator.impl.*;
import com.buyalskaya.appliance.model.entity.*;

import java.util.*;
import java.util.stream.Collectors;

public class ApplianceCreator {
    private final static String REGEX_EQUALITY = "=";

    public Appliance createAppliance(List<String> applianceParameters) {
        ApplianceType applianceType = Arrays.stream(ApplianceType.values())
                .filter(a -> a.name().equals(applianceParameters.get(0).toUpperCase().trim()))
                .findFirst().get();
        Appliance appliance = null;
        Map<ApplianceParameter, String> parameters = applianceParameters
                .subList(1, applianceParameters.size())
                .stream()
                .map(a -> List.of(a.split(REGEX_EQUALITY)))
                .collect(Collectors.toMap(a -> ApplianceParameter.valueOf(a.get(0).toUpperCase()), a -> a.get(1)));
        switch (applianceType) {
            case OVEN:
                OvenFactory ovenFactory = new OvenFactory();
                appliance = ovenFactory.createAppliance(parameters);
                break;
            case LAPTOP:
                LaptopFactory laptopFactory = new LaptopFactory();
                appliance = laptopFactory.createAppliance(parameters);
                break;
            case REFRIGERATOR:
                RefrigeratorFactory refrigeratorFactory = new RefrigeratorFactory();
                appliance = refrigeratorFactory.createAppliance(parameters);
                break;
            case VACUUMCLEANER:
                VacuumCleanerFactory vacuumCleanerFactory = new VacuumCleanerFactory();
                appliance = vacuumCleanerFactory.createAppliance(parameters);
                break;
            case TABLETPC:
                TabletPcFactory tabletPcFactory = new TabletPcFactory();
                appliance = tabletPcFactory.createAppliance(parameters);
                break;
            case SPEAKERS:
                SpeakerFactory speakerFactory = new SpeakerFactory();
                appliance = speakerFactory.createAppliance(parameters);
                break;
        }
        return appliance;
    }
}