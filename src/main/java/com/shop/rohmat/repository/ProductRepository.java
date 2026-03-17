package com.shop.rohmat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shop.rohmat.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
