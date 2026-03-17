package com.shop.rohmat.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookDto {
    private int id;
    private String title;
    private int price;
}
