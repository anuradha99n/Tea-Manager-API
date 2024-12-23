package com.my_projects.Tea_Manager.entity;

public enum PriceTypeENUM {
    EMPLOYEE(1),
    FACTORY(2);

    private final int value;

    PriceTypeENUM(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PriceTypeENUM fromValue(int value) {
        for (PriceTypeENUM type : PriceTypeENUM.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid value for PriceTypeENUM: " + value);
    }
}
