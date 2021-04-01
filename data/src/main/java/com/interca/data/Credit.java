package com.interca.data;

public class Credit {
    private final String creditName;
    private final int ID;
    
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
}
