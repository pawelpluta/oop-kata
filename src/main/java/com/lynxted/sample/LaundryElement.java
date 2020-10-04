package com.lynxted.sample;

import java.math.BigDecimal;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

abstract class LaundryElement {

    private static final Boolean IS_CLEAN = TRUE;
    private final String color;
    private final BigDecimal weight;
    private Boolean dirty;

    private LaundryElement(String color, BigDecimal weight, Boolean dirty) {
        this.color = color;
        this.weight = weight;
        this.dirty = dirty;
    }

    static LaundryElement wool(String color, BigDecimal weight) {
        return new WoolLaundryElement(color, weight, IS_CLEAN);
    }

    static LaundryElement cotton(String color, BigDecimal weight) {
        return new CottonLaundryElement(color, weight, IS_CLEAN);
    }

    static LaundryElement silk(String color, BigDecimal weight) {
        return new SilkLaundryElement(color, weight, IS_CLEAN);
    }

    String getColor() {
        return color;
    }

    BigDecimal getWeight() {
        return weight;
    }

    void clean() {
        this.dirty = FALSE;
    }

    void dirty() {
        this.dirty = TRUE;
    }

    static class WoolLaundryElement extends LaundryElement {
        private WoolLaundryElement(String color, BigDecimal weight, Boolean dirty) {
            super(color, weight, dirty);
        }
    }

    static class CottonLaundryElement extends LaundryElement {
        private CottonLaundryElement(String color, BigDecimal weight, Boolean dirty) {
            super(color, weight, dirty);
        }
    }

    static class SilkLaundryElement extends LaundryElement {
        private SilkLaundryElement(String color, BigDecimal weight, Boolean dirty) {
            super(color, weight, dirty);
        }
    }
}
