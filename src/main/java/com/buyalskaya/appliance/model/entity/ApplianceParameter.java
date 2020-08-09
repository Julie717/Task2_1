package com.buyalskaya.appliance.model.entity;

import com.buyalskaya.appliance.validator.DataValidator;

import java.util.function.Predicate;

public enum ApplianceParameter implements Predicate<String> {
    POWER_CONSUMPTION {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isPowerConsumptionValid(value);
        }
    },
    BATTERY_CAPACITY {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isBatteryCapacityValid(value);
        }
    },
    WEIGHT {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isWeightValid(value);
        }
    },
    OS {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isOsValid(value);
        }
    },
    FILTER_TYPE {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isFilterTypeValid(value);
        }
    },
    DISPLAY_INCHES {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isDisplayInchesValid(value);
        }
    },
    NUMBER_OF_SPEAKERS {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isNumberOfSpeakersValid(value);
        }
    },
    CAPACITY {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isCapacityValid(value);
        }
    },
    MEMORY_ROM {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isMemoryRomValid(value);
        }
    },
    FREEZER_CAPACITY {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isFreezerCapacityValid(value);
        }
    },
    BAG_TYPE {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isBagTypeValid(value);
        }
    },
    FREQUENCY_RANGE {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isFrequencyRangeValid(value);
        }
    },
    DEPTH {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isDepthValid(value);
        }
    },
    SYSTEM_MEMORY {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isSystemMemoryValid(value);
        }
    },
    OVERALL_CAPACITY {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isOverallCapacityValid(value);
        }
    },
    WAND_TYPE {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isWandTypeValid(value);
        }
    },
    FLASH_MEMORY_CAPACITY {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isFlashMemoryCapacityValid(value);
        }
    },
    CORD_LENGTH {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isCordLengthValid(value);
        }
    },
    HEIGHT {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isHeightValid(value);
        }
    },
    CPU {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isCpuValid(value);
        }
    },
    MOTOR_SPEED_REGULATION {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isMotorSpeedRegulationValid(value);
        }
    },
    COLOR {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isColorValid(value);
        }
    },
    WIDTH {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isWidthValid(value);
        }
    },
    CLEANING_WIDTH {
        @Override
        public boolean test(String value) {
            DataValidator dataValidator = new DataValidator();
            return dataValidator.isCleaningWidthValid(value);
        }
    }
}