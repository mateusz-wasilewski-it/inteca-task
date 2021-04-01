package com.interca.customer.controller;

import com.interca.customer.model.CustomerDb;
import com.interca.customer.model.CustomerRepository;
import com.interca.data.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    
    @PostMapping(value="/createCustomer")
    public String createCustomer(@RequestBody Customer customer){
        CustomerDb customerDb = customerRepository.save(CustomerDb.parseFromCustomerObject(customer));
        //TODO
        return customer.toString();
    }

    @GetMapping(value="/getCustomers")
    public Iterable<CustomerDb> getCustomers(){
        return customerRepository.findAll();
    }
    
}
