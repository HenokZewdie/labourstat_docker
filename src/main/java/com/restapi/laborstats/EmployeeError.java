package com.restapi.laborstats;

public enum EmployeeError {
    INVALID_ID("ERR_001", "ID is missing"),
    INVALID_FIRST_NAME("ERR_001", "First name is missing"),
    INVALID_LAST_NAME("ERR_001", "Invalid last name or last name is missing");

    private final String code;
    private final String description;

    EmployeeError(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
