package com.lynxted.sample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.lynxted.sample.Fabric.COTTON;
import static com.lynxted.sample.Fabric.SILK;
import static com.lynxted.sample.Fabric.WOOL;

class WashingService {

    private static final BigDecimal MAX_LAUNDRY_WEIGHT = BigDecimal.valueOf(7);

    Collection<LaundryElement> washWool(WashingMachine washingMachine, Collection<LaundryElement> laundry, Integer spinSpeed, Integer temperature) {
        List<LaundryElement> laundryToBeDone = maximumLoadFrom(laundry, WOOL);
        washingMachine.setLaundry(laundryToBeDone);
        if (spinSpeed >= 0 && spinSpeed <= 400) {
            washingMachine.setSpinSpeed(spinSpeed);
        } else {
            washingMachine.setSpinSpeed(400);
        }
        if (temperature >= 0 && temperature <= 40) {
            washingMachine.setTemperature(temperature);
        } else {
            washingMachine.setTemperature(40);
        }
        washingMachine.wash();
        return washingMachine.getLaundry();
    }

    Collection<LaundryElement> washCotton(WashingMachine washingMachine, Collection<LaundryElement> laundry, Integer spinSpeed, Integer temperature) {
        List<LaundryElement> laundryToBeDone = maximumLoadFrom(laundry, COTTON);
        washingMachine.setLaundry(laundryToBeDone);
        if (spinSpeed >= 0 && spinSpeed <= 1200) {
            washingMachine.setSpinSpeed(spinSpeed);
        } else {
            washingMachine.setSpinSpeed(1200);
        }
        if (temperature >= 0 && temperature <= 95) {
            washingMachine.setTemperature(temperature);
        } else {
            washingMachine.setTemperature(95);
        }
        washingMachine.wash();
        return washingMachine.getLaundry();
    }

    Collection<LaundryElement> washSilk(WashingMachine washingMachine, Collection<LaundryElement> laundry, Integer spinSpeed, Integer temperature) {
        List<LaundryElement> laundryToBeDone = maximumLoadFrom(laundry, SILK);
        washingMachine.setLaundry(laundryToBeDone);
        if (spinSpeed >= 0 && spinSpeed <= 300) {
            washingMachine.setSpinSpeed(spinSpeed);
        } else {
            washingMachine.setSpinSpeed(300);
        }
        if (temperature >= 0 && temperature <= 30) {
            washingMachine.setTemperature(temperature);
        } else {
            washingMachine.setTemperature(30);
        }
        washingMachine.wash();
        return washingMachine.getLaundry();
    }

    private List<LaundryElement> maximumLoadFrom(Collection<LaundryElement> laundry, Fabric fabricType) {
        List<LaundryElement> laundryToBeDone = new ArrayList<>();
        laundry.stream()
               .filter(laundryElement -> laundryElement.getType().equals(fabricType))
               .forEach(nextLaundryElement -> {
                   if (canFitAnotherLaundry(laundryToBeDone, nextLaundryElement)) {
                       laundryToBeDone.add(nextLaundryElement);
                   }
               });
        return laundryToBeDone;
    }

    private boolean canFitAnotherLaundry(List<LaundryElement> laundryToBeDone, LaundryElement nextLaundryElement) {
        return totalWeightOf(laundryToBeDone).add(nextLaundryElement.getWeight()).compareTo(MAX_LAUNDRY_WEIGHT) <= 0;
    }

    private BigDecimal totalWeightOf(List<LaundryElement> laundry) {
        return laundry.stream().map(LaundryElement::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
