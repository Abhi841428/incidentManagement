package com.system.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum IncidentStatus {
    OPEN("Open"),
    CLOSED("Closed"),
    IN_PROGRESS("In Progress");

    private final String value;

    IncidentStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static IncidentStatus fromValue(String value) {
        for (IncidentStatus status : IncidentStatus.values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid IncidentStatus value: " + value);
    }
}
