package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.AbstractFactory;
import com.buyalskaya.appliance.model.entity.Appliance;
import com.buyalskaya.appliance.model.entity.ApplianceParameter;
import com.buyalskaya.appliance.model.entity.impl.Speaker;

import java.util.Map;

public class SpeakerFactory implements AbstractFactory {
    private final static String REGEX_DASH = "-";

    @Override
    public Appliance createAppliance(Map<ApplianceParameter, String> parameters) {
        Speaker speaker = new Speaker();
        for (ApplianceParameter parameter : parameters.keySet()) {
            switch (parameter) {
                case POWER_CONSUMPTION:
                    double powerConsumption = Double.parseDouble(parameters.get(parameter));
                    speaker.setPowerConsumption(powerConsumption);
                    break;
                case NUMBER_OF_SPEAKERS:
                    int numberOfSpeakers = Integer.parseInt(parameters.get(parameter));
                    speaker.setNumberOfSpeakers(numberOfSpeakers);
                    break;
                case FREQUENCY_RANGE:
                    String[] frequencies = parameters.get(parameter).split(REGEX_DASH);
                    double startFrequencyRange = Double.parseDouble(frequencies[0]);
                    double endFrequencyRange = Double.parseDouble(frequencies[1]);
                    speaker.setStartFrequencyRange(startFrequencyRange);
                    speaker.setEndFrequencyRange(endFrequencyRange);
                    break;
                case CORD_LENGTH:
                    int cordLength = Integer.parseInt(parameters.get(parameter));
                    speaker.setCordLength(cordLength);
                    break;
            }
        }
        return speaker;
    }
}