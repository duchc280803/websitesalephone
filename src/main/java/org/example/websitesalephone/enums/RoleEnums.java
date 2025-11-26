package org.example.websitesalephone.enums;

public enum RoleEnums {

    ADMIN("ADMIN"),

    STAFF("STAFF"),

    CUSTOMER("CUSTOMER");

    private final String value;

    RoleEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
