package com.interca.data;

public class Customer {
    private final int creditId;
    private final String firstName;
    private final String pesel;
    private final String surname;

    public Customer(int creditId, String firstName, String pesel, String surname) {
        this.creditId = creditId;
        this.firstName = firstName;
        this.pesel = pesel;
        this.surname = surname;
    }

    public int getCreditId() {
        return creditId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPesel() {
        return pesel;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Customer{" +
            "creditId=" + creditId +
            ", firstName='" + firstName + '\'' +
            ", pesel='" + pesel + '\'' +
            ", surname='" + surname + '\'' +
            '}';
    }
}
