package com.interca.credit.controller;

import com.interca.data.Customer;
import com.interca.data.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreditService {
    private final RestTemplate restTemplate;

    public CreditService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private static final String CUSTOMER_SERVICE = "http://localhost:8001";
    private static final String PRODUCT_SERVICE = "http://localhost:8002";

    public void postProduct(Product product) {
        String url = PRODUCT_SERVICE + "/createProduct";
        restTemplate.postForEntity(url, product, String.class);
    }

    public void postCustomer(Customer customer) {
        String url = CUSTOMER_SERVICE + "/createCustomer";
        restTemplate.postForEntity(url, customer, String.class);
    }

    public Product[] getProducts() {
        String url = PRODUCT_SERVICE + "/getProducts";
        return restTemplate.getForObject(url, Product[].class);
    }

    public Customer[] getCustomers() {
        String url = CUSTOMER_SERVICE + "/getCustomers";
        return restTemplate.getForObject(url, Customer[].class);
    }
}
