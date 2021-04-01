package com.interca.credit.controller;

import com.interca.credit.model.CreditDb;
import com.interca.credit.model.CreditRepository;
import com.interca.credit.view.ResponseFormatter;
import com.interca.data.Credit;
import com.interca.data.CreditRequestForm;
import com.interca.data.Customer;
import com.interca.data.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CreditController {
    public final static String NOT_VALID_REQUEST_RESPONSE = "sorry some arguments are missing";
    
    @Autowired
    private CreditRepository creditRepository;
    
    @Autowired
    private CreditService creditService;

    @GetMapping("/getCredits")
    public List<String> getCredits() {
        Customer[] customers = creditService.getCustomers();
        Product[] products = creditService.getProducts();
        Iterable<CreditDb> creditDbs = creditRepository.findAll();
        List<Credit> credits = new ArrayList<>();
        creditDbs.forEach(credit -> credits.add(credit.toCreditObject()));
        return ResponseFormatter.formatString(credits.toArray(new Credit[]{}), products, customers);
    }

    @PostMapping("/createCredit")
    public String createCredit(@RequestBody CreditRequestForm creditRequestForm) {
        if (creditRequestForm.checkIfNotValid()) {
            return NOT_VALID_REQUEST_RESPONSE;
        }
        CreditDb creditDb = creditRepository.save(
            CreditDb.parseFromCreditObject(
                creditRequestForm.extractCreditObject()));
        creditRequestForm.setCreditId(creditDb.getId());
        Customer customer = creditRequestForm.extractCustomerObject();
        Product product = creditRequestForm.extractProductObject();
        creditService.postCustomer(customer);
        creditService.postProduct(product);
        return String.valueOf(creditDb.getId());
    }


}
