package com.buyalskaya.appliance.model.entity.impl;

import com.buyalskaya.appliance.model.entity.ComputerAppliance;
import com.buyalskaya.appliance.model.entity.ComputerOperationSystem;

import java.util.StringJoiner;

public class Laptop extends ComputerAppliance {
    private ComputerOperationSystem operationSystem;
    private int systemMemory;
    private double cpu;

    public ComputerOperationSystem getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(ComputerOperationSystem operationSystem) {
        this.operationSystem = operationSystem;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
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
        Laptop laptop = (Laptop) obj;
        return (operationSystem == laptop.operationSystem) &&
                (systemMemory == laptop.systemMemory) &&
                (cpu == laptop.cpu);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + operationSystem.hashCode() + systemMemory + (int) cpu;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add(super.toString())
                .add("operationSystem=" + operationSystem)
                .add("systemMemory=" + systemMemory)
                .add("cpu=" + cpu)
                .toString();
    }
}