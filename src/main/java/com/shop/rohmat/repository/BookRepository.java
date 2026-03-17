package com.shop.rohmat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.rohmat.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
