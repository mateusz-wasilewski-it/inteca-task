package com.interca.data;

public class CreditRequestForm {
    private final String creditName;
    private int creditId;
    private final String firstName;
    private final String pesel;
    private final String surname;
    private final String productName;
    private final int value;
    
    public CreditRequestForm(String creditName, String firstName, String pesel, String surname, String productName, int value) {
        this.creditName = creditName;
        this.firstName = firstName;
        this.pesel = pesel;
        this.surname = surname;
        this.productName = productName;
        this.value = value;
    }

    public void setCreditId(int creditId) {
        this.creditId = creditId;
    }

    public Credit extractCreditObject() {
        return new Credit(this.creditName, creditId);
    }

    public Customer extractCustomerObject() {
        return new Customer(creditId, firstName, pesel, surname);
    }

    public Product extractProductObject() {
        return new Product(creditId, productName, value);
    }

    @Override
    public String toString() {
        return "CreditRequestForm{" +
            "creditName='" + creditName + '\'' +
            ", creditId=" + creditId +
            ", firstName='" + firstName + '\'' +
            ", pesel='" + pesel + '\'' +
            ", surname='" + surname + '\'' +
            ", productName='" + productName + '\'' +
            ", value=" + value +
            '}';
    }
}
