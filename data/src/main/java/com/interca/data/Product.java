package com.interca.data;

public class Product {
    private final int creditId;
    private final String productName;
    private final int value;

    public Product(int creditId, String productName, int value) {
        this.creditId = creditId;
        this.productName = productName;
        this.value = value;
    }

    public int getCreditId() {
        return creditId;
    }

    public String getProductName() {
        return productName;
    }

    public int getValue() {
        return value;
    }
}
