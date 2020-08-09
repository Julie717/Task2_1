package com.buyalskaya.appliance.model.entity;

import java.util.StringJoiner;

public abstract class KitchenAppliance extends ElectricalAppliance {
    private double weight;
    private double height;
    private double width;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
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
        KitchenAppliance kitchenAppliance = (KitchenAppliance) obj;
        return (weight == kitchenAppliance.weight) &&
                (height == kitchenAppliance.height) &&
                (width == kitchenAppliance.width);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (int) weight * 7 + (int) height + (int) width;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "", "")
                .add(super.toString())
                .add("weight=" + weight)
                .add("height=" + height)
                .add("width=" + width)
                .toString();
    }
}