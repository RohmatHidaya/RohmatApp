package com.shop.rohmat.mappers;

import org.mapstruct.Mapper;

import com.shop.rohmat.dtos.UserDto;
import com.shop.rohmat.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
