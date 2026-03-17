package com.shop.rohmat.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerDto {
    private int id;
    private String name;
    private String email;
}
