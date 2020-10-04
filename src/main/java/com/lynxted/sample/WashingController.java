package com.lynxted.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import static com.lynxted.sample.Fabric.COTTON;
import static com.lynxted.sample.Fabric.SILK;

class WashingController {

    private final WashingService washingService;

    WashingController(WashingService washingService) {
        this.washingService = washingService;
    }

    void wash(Fabric fabricType) {
        Collection<LaundryElement> laundry = getAllLaundry();
        WashingMachine washingMachine = new WashingMachine();
        Integer spinSpeed = getRequestedSpinSpeed();
        Integer temperature = getRequestedTemperature();
        if (fabricType == Fabric.WOOL) {
            washingService.washWool(washingMachine, laundry, spinSpeed, temperature);
        } else if (fabricType == COTTON) {
            washingService.washCotton(washingMachine, laundry, spinSpeed, temperature);
        } else if (fabricType == SILK) {
            washingService.washSilk(washingMachine, laundry, spinSpeed, temperature);
        }
    }

    private Collection<LaundryElement> getAllLaundry() {
        Collection<LaundryElement> allLaundry = new ArrayList<>();
        // fill the allLaundry collection with available laundry by any way, e.g. obtaining it from repositories, providers, services
        return allLaundry;
    }

    private Integer getRequestedSpinSpeed() {
        return new Random().nextInt(1200);
    }

    private Integer getRequestedTemperature() {
        return new Random().nextInt(95);
    }

}
