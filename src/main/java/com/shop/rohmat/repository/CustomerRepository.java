package com.shop.rohmat.repository;

import org.springframework.data.repository.CrudRepository;

import com.shop.rohmat.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
