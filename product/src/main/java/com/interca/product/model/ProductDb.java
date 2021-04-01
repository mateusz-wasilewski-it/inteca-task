package com.interca.product.model;

import com.interca.data.Product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductDb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    private int CreditId;

    private String productName;

    private int value;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCreditId() {
        return CreditId;
    }

    public void setCreditId(int creditId) {
        CreditId = creditId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static ProductDb parseFromProductObject(Product product) {
        ProductDb productDb = new ProductDb();
        productDb.setCreditId(product.getCreditId());
        productDb.setProductName(product.getProductName());
        productDb.setValue(product.getValue());
        return productDb;
    }

    public Product toProductObject() {
        return new Product(getCreditId(), getProductName(), getValue());
    }
}
