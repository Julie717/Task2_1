package com.buyalskaya.appliance.model.entity;

import java.util.StringJoiner;

public abstract class ElectricalAppliance extends Appliance {
    private double powerConsumption;

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        ElectricalAppliance electricalAppliance = (ElectricalAppliance) obj;
        return powerConsumption == electricalAppliance.powerConsumption;
    }

    @Override
    public int hashCode() {
        return (int) powerConsumption * 31;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "", "")
                .add("powerConsumption=" + powerConsumption)
                .toString();
    }
}