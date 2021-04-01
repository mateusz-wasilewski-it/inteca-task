package com.interca.credit.model;

import com.interca.data.Credit;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditDb {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }
    @Id
    private int id;
    
    private String creditName;
    
    public static CreditDb parseFromCreditObject(Credit credit){
        CreditDb creditDb = new CreditDb();
        creditDb.setId(credit.getID());
        creditDb.setCreditName(credit.getCreditName());
        return creditDb;
    }
    
}
