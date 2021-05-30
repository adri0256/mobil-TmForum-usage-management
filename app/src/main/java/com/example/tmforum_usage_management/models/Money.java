package com.example.tmforum_usage_management.models;

public class Money {
    private String unit;
    private Double value;

    public Money() {
    }

    public Money(String unit, Double value) {
        this.unit = unit;
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
