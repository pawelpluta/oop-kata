package com.lynxted.sample;

class SpinSpeed {

    private static final Integer NO_SPIN_SPEED = 0;
    private final Integer rpm;

    private SpinSpeed(Integer rpm) {
        if (rpm < NO_SPIN_SPEED) {
            throw new IllegalArgumentException("Spin speed cannot be negative");
        }
        this.rpm = rpm;
    }

    static SpinSpeed forRpm(Integer value) {
        return new SpinSpeed(value);
    }

    boolean isLowerOrEqual(SpinSpeed anotherSpinSpeed) {
        return rpm <= anotherSpinSpeed.rpm;
    }
}
