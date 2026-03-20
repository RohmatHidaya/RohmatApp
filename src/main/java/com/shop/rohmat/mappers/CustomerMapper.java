package com.shop.rohmat.mappers;

import org.mapstruct.Mapper;

import com.shop.rohmat.dtos.CustomerDto;
import com.shop.rohmat.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);
}
