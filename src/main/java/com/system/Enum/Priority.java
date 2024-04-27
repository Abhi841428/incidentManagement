package com.system.Enum;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Priority {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");

    private final String value;

    Priority(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Priority fromValue(String value) {
        for (Priority p : Priority.values()) {
            if (p.value.equalsIgnoreCase(value)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid Priority value: " + value);
    }
}
