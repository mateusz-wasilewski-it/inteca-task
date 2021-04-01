package com.interca.product.controller;

import com.interca.data.Product;
import com.interca.product.model.ProductDb;
import com.interca.product.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.interca.product.model.ProductDb.parseFromProductObject;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @PostMapping(value = "/createProduct")
    public String createProduct(@RequestBody Product customer) {
        ProductDb customerDb = productRepository.save(parseFromProductObject(customer));
        return customer.toString();
    }

    @GetMapping(value = "/getProducts")
    public Product[] getProducts() {
        Iterable<ProductDb> productDbs = productRepository.findAll();
        List<Product> products = new ArrayList<>();
        productDbs.forEach(productDb -> products.add(productDb.toProductObject()));
        return products.toArray(new Product[]{});
    }

}
