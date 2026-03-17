package com.shop.rohmat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.rohmat.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
