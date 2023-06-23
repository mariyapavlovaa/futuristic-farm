package com.uni.fmi.futuristicfarm.farmenum;

public enum UserPositionEnum {

    ADMIN("Admin"),
    CLIENT("Client");

    public final String userPositionValue;

    UserPositionEnum(final String user) {
        this.userPositionValue = user;
    }
}