package com.shop.rohmat.mappers;

import org.mapstruct.Mapper;

import com.shop.rohmat.dtos.ProductDto;
import com.shop.rohmat.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);
}
