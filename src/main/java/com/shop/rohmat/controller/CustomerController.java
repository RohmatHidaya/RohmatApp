package com.shop.rohmat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.rohmat.model.Customer;
import com.shop.rohmat.repository.CustomerRepository;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping(path = "/customers")
    public @ResponseBody String addNewCustomer(@RequestParam String name, @RequestParam String email,
            @RequestParam String address) {
        Customer c = new Customer();
        c.setName(name);
        c.setEmail(email);
        c.setAddress(address);
        customerRepository.save(c);
        return "Saved";
    }

    @GetMapping(path = "/allCustomers")
    public @ResponseBody Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
