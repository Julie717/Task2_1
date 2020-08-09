package com.buyalskaya.appliance.model.entity.impl;

import com.buyalskaya.appliance.model.entity.ComputerAppliance;
import com.buyalskaya.appliance.model.entity.ApplianceColor;

import java.util.StringJoiner;

public class TabletPc extends ComputerAppliance {
    private int flashMemoryCapacity;
    private ApplianceColor color;

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(int flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public ApplianceColor getColor() {
        return color;
    }

    public void setColor(ApplianceColor color) {
        this.color = color;
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
        TabletPc tabletPc = (TabletPc) obj;
        return (flashMemoryCapacity == tabletPc.flashMemoryCapacity) &&
                (color == tabletPc.color);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + flashMemoryCapacity + color.hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add(super.toString())
                .add("flashMemoryCapacity=" + flashMemoryCapacity)
                .add("color=" + color)
                .toString();
    }
}