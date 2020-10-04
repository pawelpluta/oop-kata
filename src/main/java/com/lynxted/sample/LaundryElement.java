package com.lynxted.sample;

import java.math.BigDecimal;

class LaundryElement {

    private Fabric type;
    private String color;
    private BigDecimal weight;
    private Boolean dirty;

    LaundryElement(Fabric type, String color, BigDecimal weight, Boolean dirty) {
        this.type = type;
        this.color = color;
        this.weight = weight;
        this.dirty = dirty;
    }

    Fabric getType() {
        return type;
    }

    void setType(Fabric type) {
        this.type = type;
    }

    String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }

    BigDecimal getWeight() {
        return weight;
    }

    void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    Boolean getDirty() {
        return dirty;
    }

    void setDirty(Boolean dirty) {
        this.dirty = dirty;
    }
}
