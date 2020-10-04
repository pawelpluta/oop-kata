package com.lynxted.sample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

class Laundry {

    private final List<LaundryElement> allLaundry;

    private Laundry(List<LaundryElement> allLaundry) {
        this.allLaundry = allLaundry;
    }

    static Laundry of(List<LaundryElement> allLaundry) {
        return new Laundry(allLaundry);
    }

    List<LaundryElement> asList() {
        return unmodifiableList(allLaundry);
    }

    Laundry with(Laundry newLaundryToBeDone) {
        List<LaundryElement> updatedLaundry = new ArrayList<>(allLaundry);
        updatedLaundry.addAll(newLaundryToBeDone.asList());
        return Laundry.of(updatedLaundry);
    }

    Laundry with(LaundryElement newLaundryToBeDone) {
        List<LaundryElement> updatedLaundry = new ArrayList<>(allLaundry);
        updatedLaundry.add(newLaundryToBeDone);
        return Laundry.of(updatedLaundry);
    }

    Laundry withOut(Laundry removedElements) {
        List<LaundryElement> updatedLaundry = new ArrayList<>(allLaundry);
        updatedLaundry.removeAll(removedElements.asList());
        return Laundry.of(updatedLaundry);
    }

    BigDecimal weight() {
        return allLaundry.stream().map(LaundryElement::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
