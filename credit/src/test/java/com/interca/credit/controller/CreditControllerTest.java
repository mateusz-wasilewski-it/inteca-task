package com.interca.credit.controller;

import com.interca.data.CreditRequestForm;
import org.junit.jupiter.api.Test;

import static com.interca.credit.controller.CreditController.NOT_VALID_REQUEST_RESPONSE;
import static org.junit.jupiter.api.Assertions.*;

class CreditControllerTest {

    @Test
    void getCredits() {
    }

    @Test
    void createCredit() {
        //given
        CreditController creditController = new CreditController();
        
        //when
        CreditRequestForm incompleteCreditRequestForm = 
            new CreditRequestForm("cName", "name", "pesel", null, "pName", 100);
        
        //then
        assertEquals(creditController.createCredit(incompleteCreditRequestForm), NOT_VALID_REQUEST_RESPONSE);
    }
}