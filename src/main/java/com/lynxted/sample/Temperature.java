package com.lynxted.sample;

class Temperature {

    private static final Integer CELSIUS_FREEZING_POINT_OF_WATER = 0;

    private final Integer celsiusValue;

    private Temperature(Integer celsiusValue) {
        this.celsiusValue = celsiusValue;
    }

    static Temperature celsius(Integer value) {
        return new Temperature(value);
    }

    boolean isOverFreezingPoint() {
        return celsiusValue > CELSIUS_FREEZING_POINT_OF_WATER;
    }

    boolean isLowerOrEqual(Temperature anotherTemperature) {
        return celsiusValue <= anotherTemperature.celsiusValue;
    }
}
