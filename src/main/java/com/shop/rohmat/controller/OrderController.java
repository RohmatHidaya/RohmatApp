package com.shop.rohmat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.rohmat.dtos.OrderDto;
import com.shop.rohmat.repository.OrderRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/orders")
public class OrderController {
    private final OrderRepository orderRepository;

    @GetMapping
    public @ResponseBody Iterable<OrderDto> GetAllOrder() {
        return orderRepository.findAll().stream().map(order -> new OrderDto(order.getId(), order.getCustomer_id()))
                .toList();
    }

}
