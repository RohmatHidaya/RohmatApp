package com.shop.rohmat.repository;

import com.shop.rohmat.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
