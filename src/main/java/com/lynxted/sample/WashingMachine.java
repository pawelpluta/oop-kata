package com.lynxted.sample;

import java.util.Collection;

class WashingMachine {

    private Integer temperature;
    private Integer spinSpeed;
    private Collection<LaundryElement> laundry;

    Integer getTemperature() {
        return temperature;
    }

    void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    Integer getSpinSpeed() {
        return spinSpeed;
    }

    void setSpinSpeed(Integer spinSpeed) {
        this.spinSpeed = spinSpeed;
    }

    Collection<LaundryElement> getLaundry() {
        return laundry;
    }

    void setLaundry(Collection<LaundryElement> laundry) {
        this.laundry = laundry;
    }

    void wash() {
        laundry.forEach(laundryElement -> laundryElement.setDirty(false));
    }
}
