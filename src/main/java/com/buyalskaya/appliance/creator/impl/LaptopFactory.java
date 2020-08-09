package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.AbstractFactory;
import com.buyalskaya.appliance.model.entity.*;
import com.buyalskaya.appliance.model.entity.impl.Laptop;

import java.util.Map;

public class LaptopFactory implements AbstractFactory {
    @Override
    public Appliance createAppliance(Map<ApplianceParameter, String> parameters) {
        Laptop laptop = new Laptop();
        for (ApplianceParameter parameter : parameters.keySet()) {
            switch (parameter) {
                case BATTERY_CAPACITY:
                    double batteryCapacity = Double.parseDouble(parameters.get(parameter));
                    laptop.setBatteryCapacity(batteryCapacity);
                    break;
                case OS:
                    ComputerOperationSystem os = ComputerOperationSystem
                            .valueOf(parameters.get(parameter).toUpperCase());
                    laptop.setOperationSystem(os);
                    break;
                case MEMORY_ROM:
                    int memoryRom = Integer.parseInt(parameters.get(parameter));
                    laptop.setMemoryRom(memoryRom);
                    break;
                case SYSTEM_MEMORY:
                    int systemRom = Integer.parseInt(parameters.get(parameter));
                    laptop.setSystemMemory(systemRom);
                    break;
                case CPU:
                    double cpu = Double.parseDouble(parameters.get(parameter));
                    laptop.setCpu(cpu);
                    break;
                case DISPLAY_INCHES:
                    int displayInches = Integer.parseInt(parameters.get(parameter));
                    laptop.setDisplayInches(displayInches);
                    break;
            }
        }
        return laptop;
    }
}