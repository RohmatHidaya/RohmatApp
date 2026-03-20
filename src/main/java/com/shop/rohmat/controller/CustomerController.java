package com.shop.rohmat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.rohmat.dtos.CustomerDto;
import com.shop.rohmat.model.Customer;
import com.shop.rohmat.repository.CustomerRepository;
import com.shop.rohmat.mappers.CustomerMapper;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @PostMapping(path = "/customer/add")
    public @ResponseBody String addNewCustomer(@RequestParam String name, @RequestParam String email,
            @RequestParam String address) {
        Customer c = new Customer();
        c.setName(name);
        c.setEmail(email);
        c.setAddress(address);
        customerRepository.save(c);
        return "Saved";
    }

    @GetMapping
    public @ResponseBody Iterable<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> customerMapper.toDto(customer))
                .toList();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Integer id) {
        var customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerMapper.toDto(customer));
    }
}
