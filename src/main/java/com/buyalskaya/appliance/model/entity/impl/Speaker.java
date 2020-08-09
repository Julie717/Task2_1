package com.buyalskaya.appliance.model.entity.impl;

import com.buyalskaya.appliance.model.entity.ElectricalAppliance;

import java.util.StringJoiner;

public class Speaker extends ElectricalAppliance {
    private int numberOfSpeakers;
    private double startFrequencyRange;
    private double endFrequencyRange;
    private double cordLength;

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public double getStartFrequencyRange() {
        return startFrequencyRange;
    }

    public void setStartFrequencyRange(double startFrequencyRange) {
        this.startFrequencyRange = startFrequencyRange;
    }

    public double getEndFrequencyRange() {
        return endFrequencyRange;
    }

    public void setEndFrequencyRange(double endFrequencyRange) {
        this.endFrequencyRange = endFrequencyRange;
    }

    public double getCordLength() {
        return cordLength;
    }

    public void setCordLength(double cordLength) {
        this.cordLength = cordLength;
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
        Speaker speaker = (Speaker) obj;
        return (numberOfSpeakers == speaker.numberOfSpeakers) &&
                (startFrequencyRange == speaker.startFrequencyRange) &&
                (endFrequencyRange == speaker.endFrequencyRange) &&
                (cordLength == speaker.cordLength);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + numberOfSpeakers + (int) startFrequencyRange + (int) endFrequencyRange + (int) cordLength;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add(super.toString())
                .add("numberOfSpeakers=" + numberOfSpeakers)
                .add("startFrequencyRange=" + startFrequencyRange)
                .add("endFrequencyRange=" + endFrequencyRange)
                .add("cordLength=" + cordLength)
                .toString();
    }
}