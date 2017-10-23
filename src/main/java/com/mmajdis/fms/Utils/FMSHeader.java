package com.mmajdis.fms.Utils;

import java.util.Objects;

public enum FMSHeader {

    X_FMS_TOKEN("X-FMS-Token");

    FMSHeader(String name) {
        Objects.requireNonNull(name, "name must not be empty");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static FMSHeader getForName(String name) {
        Objects.requireNonNull(name, "name must not be empty");

        for (FMSHeader r : FMSHeader.values()) {
            if (r.getName().equals(name)) {
                return r;
            }
        }
        throw new IllegalArgumentException("No '" + FMSHeader.class.getSimpleName() + "' found by name '" + name + "'.");
    }

    private final String name;
}
