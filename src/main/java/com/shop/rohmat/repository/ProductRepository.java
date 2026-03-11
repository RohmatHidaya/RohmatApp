package com.shop.rohmat.repository;

import org.springframework.data.repository.CrudRepository;
import com.shop.rohmat.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
