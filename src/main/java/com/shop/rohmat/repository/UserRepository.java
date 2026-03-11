package com.shop.rohmat.repository;

import com.shop.rohmat.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
