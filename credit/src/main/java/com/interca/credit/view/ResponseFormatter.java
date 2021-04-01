package com.interca.credit.view;

import com.interca.data.Credit;
import com.interca.data.Customer;
import com.interca.data.Product;
import io.vavr.collection.Stream;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResponseFormatter {
    public static List<String> formatString(Credit[] credits, Product[] products, Customer[] customers) {
        List<String> entities = new ArrayList<>();
        for (Credit credit : credits) {
            Customer correspondingCustomer = Stream.of(customers).find(customer -> customer.getCreditId() == credit.getID()).get();
            Product correspondingProduct = Stream.of(products).find(product -> product.getCreditId() == credit.getID()).get();
            entities.add(String.format("id: %s creditName: %s firstName: %s surname: %s pesel: %s productName: %s value: %s ",
                credit.getID(), credit.getCreditName(), correspondingCustomer.getFirstName(), correspondingCustomer.getSurname(),
                correspondingCustomer.getPesel(), correspondingProduct.getProductName(), correspondingProduct.getValue()));
        }

        return entities;
    }
}
