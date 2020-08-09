package com.buyalskaya.appliance.model.entity;

import java.util.StringJoiner;

public abstract class ComputerAppliance extends Appliance {
    private double batteryCapacity;
    private int memoryRom;
    private int displayInches;

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        ComputerAppliance computerAppliance = (ComputerAppliance) obj;
        return (batteryCapacity == computerAppliance.batteryCapacity) &&
                (memoryRom == computerAppliance.memoryRom) &&
                (displayInches == computerAppliance.displayInches);
    }

    @Override
    public int hashCode() {
        return (int) batteryCapacity * 31 + memoryRom + displayInches;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "", "")
                .add("battery_capacity=" + batteryCapacity)
                .add("memory_rom=" + memoryRom)
                .add("display_inches=" + displayInches)
                .toString();
    }
}