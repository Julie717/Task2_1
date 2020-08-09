package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.AbstractFactory;
import com.buyalskaya.appliance.model.entity.Appliance;
import com.buyalskaya.appliance.model.entity.ApplianceColor;
import com.buyalskaya.appliance.model.entity.ApplianceParameter;
import com.buyalskaya.appliance.model.entity.impl.TabletPc;

import java.util.Map;

public class TabletPcFactory implements AbstractFactory {
    @Override
    public Appliance createAppliance(Map<ApplianceParameter, String> parameters) {
        TabletPc tabletPc = new TabletPc();
        for (ApplianceParameter parameter : parameters.keySet()) {
            switch (parameter) {
                case BATTERY_CAPACITY:
                    double batteryCapacity = Double.parseDouble(parameters.get(parameter));
                    tabletPc.setBatteryCapacity(batteryCapacity);
                    break;
                case DISPLAY_INCHES:
                    int displayInches = Integer.parseInt(parameters.get(parameter));
                    tabletPc.setDisplayInches(displayInches);
                    break;
                case MEMORY_ROM:
                    int memoryRom = Integer.parseInt(parameters.get(parameter));
                    tabletPc.setMemoryRom(memoryRom);
                    break;
                case FLASH_MEMORY_CAPACITY:
                    int flashMemoryCapacity = Integer.parseInt(parameters.get(parameter));
                    tabletPc.setFlashMemoryCapacity(flashMemoryCapacity);
                    break;
                case COLOR:
                    ApplianceColor applianceColor = ApplianceColor.valueOf(parameters.get(parameter).toUpperCase());
                    tabletPc.setColor(applianceColor);
                    break;
            }
        }
        return tabletPc;
    }
}