package com.interca.customer.model;

import com.interca.data.Customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerDb {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private int creditId;

    public void setCreditId(int creditId) {
        this.creditId = creditId;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getId() {
        return id;
    }

    public int getCreditId() {
        return creditId;
    }

    public String getPesel() {
        return pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private String pesel;

    private String firstName;
    
    private String surname;
    
    
    
    public static CustomerDb parseFromCustomerObject(Customer customer){
        CustomerDb customerDb = new CustomerDb();
        customerDb.setCreditId(customer.getCreditId());
        customerDb.setFirstName(customer.getFirstName());
        customerDb.setPesel(customer.getPesel());
        customerDb.setSurname(customer.getSurname());
        return customerDb;
    }
}
