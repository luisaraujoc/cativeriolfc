package com.luisaraujoc.cativeriolfc.Enum;

public enum Role {
    // 1 - ADMIN, 2 - USER
    ADMIN("ADMIN"),
    USER("USER");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Role fromValue(String value) {
        for (Role role : Role.values()) {
            if (role.getValue().equals(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Valor desconhecido: " + value);
    }
}
