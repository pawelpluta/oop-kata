package com.lynxted.sample;

import java.math.BigDecimal;

class WashingMachine {

    private static final BigDecimal MAX_LAUNDRY_WEIGHT = BigDecimal.valueOf(7);

    private Programme programme;
    private Laundry laundry;

    void selectProgramme(Programme programme) {
        this.programme = programme;
    }

    Laundry takeOutLaundry() {
        return laundry;
    }

    Laundry addLaundry(Laundry newLaundryToBeDone) {
        newLaundryToBeDone.asList()
                          .forEach(nextLaundryElement -> {
                              if (canFit(nextLaundryElement)) {
                                  laundry = laundry.with(nextLaundryElement);
                              }
                          });
        return newLaundryToBeDone.withOut(laundry);
    }

    void start() {
        laundry.asList().forEach(laundryElement -> laundryElement.clean());
    }

    private boolean canFit(LaundryElement nextLaundryElement) {
        return laundry.weight().add(nextLaundryElement.getWeight()).compareTo(MAX_LAUNDRY_WEIGHT) <= 0;
    }

}
