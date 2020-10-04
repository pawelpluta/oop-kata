package com.lynxted.sample;

import java.util.Random;
import java.util.function.Supplier;

class Cleaner {

    void doLaundry(Supplier<Laundry> laundrySupplier, Supplier<Programme> programmeSupplier) {
        WashingMachine washingMachine = new WashingMachine();
        Basket laundryBasket = getLaundryBasket();
        Programme programme = programmeSupplier.get()
                                               .adjustTemperature(getRequestedTemperature())
                                               .adjustSpinSpeed(getRequestedSpinSpeed());

        Laundry unfittedLaundry = washingMachine.addLaundry(laundrySupplier.get());
        washingMachine.selectProgramme(programme);
        washingMachine.start();

        laundryBasket.put(unfittedLaundry);
    }

    private Basket getLaundryBasket() {
        Basket laundryBasket = Basket.empty();
        // fill the laundryBasket with available laundry by any way, e.g. obtaining it from repositories, providers, services
        return laundryBasket;
    }

    private Temperature getRequestedTemperature() {
        return Temperature.celsius(new Random().nextInt(95));
    }

    private SpinSpeed getRequestedSpinSpeed() {
        return SpinSpeed.forRpm(new Random().nextInt(1200));
    }
}
