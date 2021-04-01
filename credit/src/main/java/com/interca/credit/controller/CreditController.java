package com.interca.credit.controller;

import com.interca.credit.model.CreditDb;
import com.interca.credit.model.CreditRepository;
import com.interca.data.Credit;
import com.interca.data.CreditRequestForm;
import com.interca.data.Customer;
import com.interca.data.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CreditController {
    @Autowired
    private CreditRepository creditRepository;
    
    @PostMapping("/test")
    public String test(@RequestBody CreditRequestForm creditRequestForm){
        return creditRequestForm.toString();
    }
    
    @GetMapping("/getCredits")
    public String getCredits(){
        // TODO
        return "get credits";
    }
    
    @PostMapping("/createCredit")
    public String createCredit(@RequestBody CreditRequestForm creditRequestForm){
        Customer customer = creditRequestForm.extractCustomerObject();
        Product product = creditRequestForm.extractProductObject();
        creditRepository.save(
            CreditDb.parseFromCreditObject(
                creditRequestForm.extractCreditObject()));
        return creditRequestForm.toString();
    }
    
    
    
}
