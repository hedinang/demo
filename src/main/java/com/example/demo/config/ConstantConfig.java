package com.example.demo.config;

public enum ConstantConfig {
    PENDING_EMPLOYEE("PENDING"),
    ACTIVE_EMPLOYEE("ACTIVE"),
    INACTIVE_EMPLOYEE("DELETED"),
    PENDING_DEPARTMENT("PENDING"),
    ACTIVE_DEPARTMENT("ACTIVE"),
    INACTIVE_DEPARTMENT("DELETED"),
    MALE("MALE"),
    FEMALE("FEMALE");

    private final String config;

    ConstantConfig(String config) {
        this.config = config;
    }

    public String getValue() {
        return this.config;
    }
}
