package com.buyalskaya.appliance.validator;

import com.buyalskaya.appliance.model.entity.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class DataValidator {
    private final static String REGEX_NUMBER = "\\d+";
    private final static String REGEX_FRACTION = "\\d+(.\\d+)?";
    private final static String REGEX_EQUALITY = "=";
    private final static String REGEX_BAG_TYPE = "\\pL[\\pL\\d]([\\pL\\d-])*";
    private final static String REGEX_WAND_TYPE = "[\\pL-]+";
    private final static String REGEX_FREQUENCY_RANGE = "\\d+(.\\d+)?-\\d+(.\\d+)?";
    private final static String REGEX_DASH = "-";

    public boolean isApplianceValid(List<String> appliance) {
        boolean isValid = false;
        if (appliance != null && !appliance.isEmpty()) {
            String applianceType = appliance.get(0);
            isValid = isApplianceTypeValid(applianceType);
            if (!isValid) {
                String[] parameterList;
                String parameterValue;
                for (int i = 1; i < appliance.size(); i++) {
                    parameterList = appliance.get(i).split(REGEX_EQUALITY);
                    String parameterName = parameterList[0];
                    parameterValue = parameterList[1];
                    isValid = isParameterNameValid(parameterName) &&
                            isParameterValueValid(parameterName, parameterValue);
                }
            }
        }
        return isValid;
    }

    public boolean isApplianceTypeValid(String applianceType) {
        boolean isValid = false;
        if (applianceType != null && !applianceType.isEmpty()) {
            isValid = Arrays.stream(ApplianceType.values())
                    .anyMatch(p -> p.name().equals(applianceType.toUpperCase()));
        }
        return isValid;
    }

    public boolean isParameterNameValid(String parameterName) {
        boolean isValid = false;
        if (parameterName != null && !parameterName.isEmpty()) {
            isValid = Arrays.stream(ApplianceParameter.values())
                    .anyMatch(o -> o.name().equals(parameterName.toUpperCase()));
        }
        return isValid;
    }

    public boolean isParameterValueValid(String parameterName, String parameterValue) {
        boolean isValid = false;
        if (isParameterNameValid(parameterName)) {
            ApplianceParameter findTag = Arrays.stream(ApplianceParameter.values())
                    .filter(f -> f.name().equals(parameterName.toUpperCase()))
                    .findFirst().get();
            isValid = findTag.test(parameterValue);
        }
        return isValid;
    }

    public boolean isPowerConsumptionValid(String powerConsumption) {
        boolean isValid = false;
        if (powerConsumption != null && !powerConsumption.isEmpty()) {
            isValid = Pattern.matches(REGEX_NUMBER, powerConsumption);
            if (isValid) {
                int powerConsumptionNumber = Integer.parseInt(powerConsumption);
                isValid = powerConsumptionNumber >= ExtremumValueApplianceParameter.MIN_POWER_CONSUMPTION &&
                        powerConsumptionNumber <= ExtremumValueApplianceParameter.MAX_POWER_CONSUMPTION;
            }
        }
        return isValid;
    }

    public boolean isBatteryCapacityValid(String batteryCapacity) {
        boolean isValid = false;
        if (batteryCapacity != null && !batteryCapacity.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, batteryCapacity);
            if (isValid) {
                double batteryCapacityNumber = Double.parseDouble(batteryCapacity);
                isValid = batteryCapacityNumber >= ExtremumValueApplianceParameter.MIN_BATTERY_CAPACITY &&
                        batteryCapacityNumber <= ExtremumValueApplianceParameter.MAX_BATTERY_CAPACITY;
            }
        }
        return isValid;
    }

    public boolean isWeightValid(String weight) {
        boolean isValid = false;
        if (weight != null && !weight.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, weight);
            if (isValid) {
                double weightNumber = Double.parseDouble(weight);
                isValid = weightNumber >= ExtremumValueApplianceParameter.MIN_WEIGHT &&
                        weightNumber <= ExtremumValueApplianceParameter.MAX_WEIGHT;
            }
        }
        return isValid;
    }

    public boolean isOsValid(String os) {
        boolean isValid = false;
        if (os != null && !os.isEmpty()) {
            isValid = Arrays.stream(ComputerOperationSystem.values())
                    .anyMatch(o -> o.name().equals(os.toUpperCase()));
        }
        return isValid;
    }

    public boolean isFilterTypeValid(String filterType) {
        boolean isValid = false;
        if (filterType != null && !filterType.isEmpty()) {
            isValid = Arrays.stream(FilterType.values())
                    .anyMatch(p -> p.name().equals(filterType.toUpperCase()));
        }
        return isValid;
    }

    public boolean isDisplayInchesValid(String displayInches) {
        boolean isValid = false;
        if (displayInches != null && !displayInches.isEmpty()) {
            isValid = Pattern.matches(REGEX_NUMBER, displayInches);
            if (isValid) {
                int displayInchesNumber = Integer.parseInt(displayInches);
                isValid = displayInchesNumber >= ExtremumValueApplianceParameter.MIN_DISPLAY_INCHES &&
                        displayInchesNumber <= ExtremumValueApplianceParameter.MAX_DISPLAY_INCHES;
            }
        }
        return isValid;
    }

    public boolean isNumberOfSpeakersValid(String numberOfSpeakers) {
        boolean isValid = false;
        if (numberOfSpeakers != null && !numberOfSpeakers.isEmpty()) {
            isValid = Pattern.matches(REGEX_NUMBER, numberOfSpeakers);
            if (isValid) {
                int numberOfSpeakersNumber = Integer.parseInt(numberOfSpeakers);
                isValid = numberOfSpeakersNumber >= ExtremumValueApplianceParameter.MIN_NUMBER_OF_SPEAKERS &&
                        numberOfSpeakersNumber <= ExtremumValueApplianceParameter.MAX_NUMBER_OF_SPEAKERS;
            }
        }
        return isValid;
    }

    public boolean isCapacityValid(String capacity) {
        boolean isValid = false;
        if (capacity != null && !capacity.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, capacity);
            if (isValid) {
                double capacityNumber = Double.parseDouble(capacity);
                isValid = capacityNumber >= ExtremumValueApplianceParameter.MIN_CAPACITY &&
                        capacityNumber <= ExtremumValueApplianceParameter.MAX_CAPACITY;
            }
        }
        return isValid;
    }

    public boolean isMemoryRomValid(String memoryRom) {
        boolean isValid = false;
        if (memoryRom != null && !memoryRom.isEmpty()) {
            isValid = Pattern.matches(REGEX_NUMBER, memoryRom);
            if (isValid) {
                int memoryRomNumber = Integer.parseInt(memoryRom);
                isValid = memoryRomNumber >= ExtremumValueApplianceParameter.MIN_MEMORY_ROM &&
                        memoryRomNumber <= ExtremumValueApplianceParameter.MAX_MEMORY_ROM;
            }
        }
        return isValid;
    }

    public boolean isFreezerCapacityValid(String capacity) {
        boolean isValid = false;
        if (capacity != null && !capacity.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, capacity);
            if (isValid) {
                double capacityNumber = Double.parseDouble(capacity);
                isValid = capacityNumber >= ExtremumValueApplianceParameter.MIN_FREEZER_CAPACITY &&
                        capacityNumber <= ExtremumValueApplianceParameter.MAX_FREEZER_CAPACITY;
            }
        }
        return isValid;
    }

    public boolean isDepthValid(String depth) {
        boolean isValid = false;
        if (depth != null && !depth.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, depth);
            if (isValid) {
                double capacityNumber = Double.parseDouble(depth);
                isValid = capacityNumber >= ExtremumValueApplianceParameter.MIN_DEPTH &&
                        capacityNumber <= ExtremumValueApplianceParameter.MAX_DEPTH;
            }
        }
        return isValid;
    }

    public boolean isHeightValid(String height) {
        boolean isValid = false;
        if (height != null && !height.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, height);
            if (isValid) {
                double heightNumber = Double.parseDouble(height);
                isValid = heightNumber >= ExtremumValueApplianceParameter.MIN_HEIGHT &&
                        heightNumber <= ExtremumValueApplianceParameter.MAX_HEIGHT;
            }
        }
        return isValid;
    }

    public boolean isWidthValid(String width) {
        boolean isValid = false;
        if (width != null && !width.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, width);
            if (isValid) {
                double widthNumber = Double.parseDouble(width);
                isValid = widthNumber >= ExtremumValueApplianceParameter.MIN_WIDTH &&
                        widthNumber <= ExtremumValueApplianceParameter.MAX_WIDTH;
            }
        }
        return isValid;
    }

    public boolean isSystemMemoryValid(String systemMemory) {
        boolean isValid = false;
        if (systemMemory != null && !systemMemory.isEmpty()) {
            isValid = Pattern.matches(REGEX_NUMBER, systemMemory);
            if (isValid) {
                int systemMemoryNumber = Integer.parseInt(systemMemory);
                isValid = systemMemoryNumber >= ExtremumValueApplianceParameter.MIN_SYSTEM_MEMORY &&
                        systemMemoryNumber <= ExtremumValueApplianceParameter.MAX_SYSTEM_MEMORY;
            }
        }
        return isValid;
    }

    public boolean isOverallCapacityValid(String capacity) {
        boolean isValid = false;
        if (capacity != null && !capacity.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, capacity);
            if (isValid) {
                double capacityNumber = Double.parseDouble(capacity);
                isValid = capacityNumber >= ExtremumValueApplianceParameter.MIN_OVERALL_CAPACITY &&
                        capacityNumber <= ExtremumValueApplianceParameter.MAX_OVERALL_CAPACITY;
            }
        }
        return isValid;
    }

    public boolean isFlashMemoryCapacityValid(String flashMemoryCapacity) {
        boolean isValid = false;
        if (flashMemoryCapacity != null && !flashMemoryCapacity.isEmpty()) {
            isValid = Pattern.matches(REGEX_NUMBER, flashMemoryCapacity);
            if (isValid) {
                int flashMemoryCapacityNumber = Integer.parseInt(flashMemoryCapacity);
                isValid = flashMemoryCapacityNumber >= ExtremumValueApplianceParameter.MIN_FLASH_MEMORY_CAPACITY &&
                        flashMemoryCapacityNumber <= ExtremumValueApplianceParameter.MAX_FLASH_MEMORY_CAPACITY;
            }
        }
        return isValid;
    }

    public boolean isCordLengthValid(String cordLength) {
        boolean isValid = false;
        if (cordLength != null && !cordLength.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, cordLength);
            if (isValid) {
                double cordLengthNumber = Double.parseDouble(cordLength);
                isValid = cordLengthNumber >= ExtremumValueApplianceParameter.MIN_CORD_LENGTH &&
                        cordLengthNumber <= ExtremumValueApplianceParameter.MAX_CORD_LENGTH;
            }
        }
        return isValid;
    }

    public boolean isCpuValid(String cpu) {
        boolean isValid = false;
        if (cpu != null && !cpu.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, cpu);
            if (isValid) {
                double cpuNumber = Double.parseDouble(cpu);
                isValid = cpuNumber >= ExtremumValueApplianceParameter.MIN_CPU &&
                        cpuNumber <= ExtremumValueApplianceParameter.MAX_CPU;
            }
        }
        return isValid;
    }

    public boolean isMotorSpeedRegulationValid(String motorSpeedRegulation) {
        boolean isValid = false;
        if (motorSpeedRegulation != null && !motorSpeedRegulation.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, motorSpeedRegulation);
            if (isValid) {
                double motorSpeedRegulationNumber = Double.parseDouble(motorSpeedRegulation);
                isValid = motorSpeedRegulationNumber >= ExtremumValueApplianceParameter.MIN_MOTOR_SPEED_REGULATION &&
                        motorSpeedRegulationNumber <= ExtremumValueApplianceParameter.MAX_MOTOR_SPEED_REGULATION;
            }
        }
        return isValid;
    }

    public boolean isColorValid(String color) {
        boolean isValid = false;
        if (color != null && !color.isEmpty()) {
            isValid = Arrays.stream(ApplianceColor.values())
                    .anyMatch(o -> o.name().equals(color.toUpperCase()));
        }
        return isValid;
    }

    public boolean isCleaningWidthValid(String cleaningWidth) {
        boolean isValid = false;
        if (cleaningWidth != null && !cleaningWidth.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, cleaningWidth);
            if (isValid) {
                double cleaningWidthNumber = Double.parseDouble(cleaningWidth);
                isValid = cleaningWidthNumber >= ExtremumValueApplianceParameter.MIN_CLEANING_WIDTH &&
                        cleaningWidthNumber <= ExtremumValueApplianceParameter.MAX_CLEANING_WIDTH;
            }
        }
        return isValid;
    }

    public boolean isBagTypeValid(String bagType) {
        boolean isValid = false;
        if (bagType != null && !bagType.isEmpty()) {
            isValid = Pattern.matches(REGEX_BAG_TYPE, bagType);
        }
        return isValid;
    }

    public boolean isWandTypeValid(String wandType) {
        boolean isValid = false;
        if (wandType != null && !wandType.isEmpty()) {
            isValid = Pattern.matches(REGEX_WAND_TYPE, wandType);
        }
        return isValid;
    }

    public boolean isFrequencyRangeValid(String frequencyRange) {
        boolean isValid = false;
        if (frequencyRange != null && !frequencyRange.isEmpty()) {
            isValid = Pattern.matches(REGEX_FREQUENCY_RANGE, frequencyRange);
            if (isValid) {
                String[] frequencies = frequencyRange.split(REGEX_DASH);
                double startFrequencyRange = Double.parseDouble(frequencies[0]);
                double endFrequencyRange = Double.parseDouble(frequencies[1]);
                isValid = startFrequencyRange >= ExtremumValueApplianceParameter.MIN_FREQUENCY &&
                        startFrequencyRange <= ExtremumValueApplianceParameter.MAX_FREQUENCY &&
                        endFrequencyRange >= ExtremumValueApplianceParameter.MIN_FREQUENCY &&
                        endFrequencyRange <= ExtremumValueApplianceParameter.MAX_FREQUENCY &&
                        startFrequencyRange <= endFrequencyRange;
            }
        }
        return isValid;
    }
}