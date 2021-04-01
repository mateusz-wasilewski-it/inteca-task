package com.interca.product.controller;

import com.interca.data.Product;
import com.interca.product.model.ProductDb;
import com.interca.product.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.interca.product.model.ProductDb.parseFromProductObject;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @PostMapping(value="/createProduct")
    public String createProduct(@RequestBody Product customer){
        ProductDb customerDb = productRepository.save(parseFromProductObject(customer));
        //TODO
        return customer.toString();
    }

    @GetMapping(value="/getProducts")
    public Iterable<ProductDb> getProducts(){
        return productRepository.findAll();
    }

}
