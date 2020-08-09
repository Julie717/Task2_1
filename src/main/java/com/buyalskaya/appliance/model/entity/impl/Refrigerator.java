package com.buyalskaya.appliance.model.entity.impl;

import com.buyalskaya.appliance.model.entity.KitchenAppliance;

import java.util.StringJoiner;

public class Refrigerator extends KitchenAppliance {
    private double freezerCapacity;
    private double overallCapacity;

    public double getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(double freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
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
        Refrigerator refrigerator = (Refrigerator) obj;
        return (freezerCapacity == refrigerator.freezerCapacity) &&
                (overallCapacity == refrigerator.overallCapacity);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (int) freezerCapacity + (int) overallCapacity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add(super.toString())
                .add("freezer_capacity=" + freezerCapacity)
                .add("overall_capacity=" + overallCapacity)
                .toString();
    }
}