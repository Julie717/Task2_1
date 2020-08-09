package com.buyalskaya.appliance.model.entity.impl;

import com.buyalskaya.appliance.model.entity.ElectricalAppliance;
import com.buyalskaya.appliance.model.entity.FilterType;

import java.util.StringJoiner;

public class VacuumCleaner extends ElectricalAppliance {
    private FilterType filterType;
    private String bagType;
    private String wandType;
    private double motorSpeedRegulation;
    private double cleaningWidth;

    public FilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(FilterType filterType) {
        this.filterType = filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public double getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(double motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public double getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(double cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        VacuumCleaner vacuumCleaner = (VacuumCleaner) obj;
        if ((bagType == null ^ vacuumCleaner.bagType == null) ||
                (bagType != null && vacuumCleaner.bagType != null && !bagType.equals(vacuumCleaner.bagType))) {
            return false;
        }
        if ((wandType == null ^ vacuumCleaner.wandType == null) ||
                (wandType != null && vacuumCleaner.wandType != null && !wandType.equals(vacuumCleaner.wandType))) {
            return false;
        }
        return (filterType == vacuumCleaner.filterType) &&
                (motorSpeedRegulation == vacuumCleaner.motorSpeedRegulation) &&
                (cleaningWidth == vacuumCleaner.cleaningWidth);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + filterType.hashCode() + (int) motorSpeedRegulation +
                (int) cleaningWidth + bagType.hashCode() + wandType.hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add(super.toString())
                .add("filter_type=" + filterType)
                .add("bag_type=" + bagType)
                .add("wand_type=" + wandType)
                .add("motor_speed_regulation=" + motorSpeedRegulation)
                .add("cleaning_width=" + cleaningWidth)
                .toString();
    }
}