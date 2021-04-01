package com.interca.data;

import jdk.nashorn.internal.runtime.options.Option;

public class Credit {
    private final String creditName;

    public Credit(String creditName, int ID) {
        this.creditName = creditName;
        this.ID = ID;
    }

    public String getCreditName() {
        return creditName;
    }

    public int getID() {
        return ID;
    }

    private final int ID;
}
