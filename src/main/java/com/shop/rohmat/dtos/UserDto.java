package com.shop.rohmat.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {
    private Integer id;
    private String name;
    private String email;
}
