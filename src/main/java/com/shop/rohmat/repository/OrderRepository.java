package com.shop.rohmat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.rohmat.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
