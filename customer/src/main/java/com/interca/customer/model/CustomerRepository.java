package com.interca.customer.model;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerDb, Integer> {
}
