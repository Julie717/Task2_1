package com.buyalskaya.appliance.model.entity.impl;

import com.buyalskaya.appliance.model.entity.KitchenAppliance;

import java.util.StringJoiner;

public class Oven extends KitchenAppliance {
    private double depth;
    private double capacity;

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
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
        Oven oven = (Oven) obj;
        return (depth == oven.depth) && (capacity == oven.capacity);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (int) depth + (int) capacity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add(super.toString())
                .add("capacity=" + capacity)
                .add("depth=" + depth)
                .toString();
    }
}