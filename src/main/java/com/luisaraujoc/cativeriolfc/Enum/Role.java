package com.luisaraujoc.cativeriolfc.Enum;

public enum Role {
    // 1 - ADMIN, 2 - USER
    ADMIN(1),
    USER(2);

    private final int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Role fromValue(int value) {
        for (Role role : Role.values()) {
            if (role.getValue() == value) {
                return role;
            }
        }
        throw new IllegalArgumentException("Valor desconhecido: " + value);
    }
}
