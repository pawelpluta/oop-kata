package com.lynxted.sample;

import com.lynxted.sample.LaundryElement.CottonLaundryElement;
import com.lynxted.sample.LaundryElement.SilkLaundryElement;
import com.lynxted.sample.LaundryElement.WoolLaundryElement;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

class Basket {

    private Laundry laundry;

    private Basket(Laundry laundry) {
        this.laundry = laundry;
    }

    static Basket empty() {
        return new Basket(Laundry.of(emptyList()));
    }

    void put(Laundry newLaundryToBeDoen) {
        laundry = laundry.with(newLaundryToBeDoen);
    }

    Laundry takeOutWool() {
        Laundry woolElements = laundryOf(WoolLaundryElement.class);
        laundry = laundry.withOut(woolElements);
        return woolElements;
    }

    Laundry takeOutCotton() {
        Laundry cottonElements = laundryOf(CottonLaundryElement.class);
        laundry = laundry.withOut(cottonElements);
        return cottonElements;
    }

    Laundry takeOutSilk() {
        Laundry silkElements = laundryOf(SilkLaundryElement.class);
        laundry = laundry.withOut(silkElements);
        return silkElements;
    }

    private Laundry laundryOf(Class<? extends LaundryElement> elementType) {
        return Laundry.of(laundry.asList().stream().filter(elementType::isInstance).collect(toList()));
    }
}
