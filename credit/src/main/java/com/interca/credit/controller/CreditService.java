package com.interca.credit.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreditService {
    private final RestTemplate restTemplate;
    public CreditService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String postCustomerInfo(){
        //TODO
        return "";
    }

    public String postProductInfo(){
        //TODO
        return "";
    }
}
