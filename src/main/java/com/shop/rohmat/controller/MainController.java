package com.shop.rohmat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shop.rohmat.repository.UserRepository;
import com.shop.rohmat.model.User;
import com.shop.rohmat.repository.CustomerRepository;
import com.shop.rohmat.repository.ProductRepository;
import com.shop.rohmat.model.Customer;
import com.shop.rohmat.model.Product;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/allUsers")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping(path = "/addProduct")
    public @ResponseBody String addNewProduct(@RequestParam String name, @RequestParam String description,
            @RequestParam double price, @RequestParam int stock) {
        Product p = new Product();
        p.setName(name);
        p.setDescription(description);
        p.setPrice(price);
        p.setStock(stock);
        productRepository.save(p);
        return "Saved";
    }

    @GetMapping(path = "/allProducts")
    public @ResponseBody Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping(path = "/UpdateStock")
    public @ResponseBody String updateStock(@RequestParam Integer id, @RequestParam int stock) {
        Product p = productRepository.findById(id).orElse(null);
        if (p != null) {
            p.setStock(stock);
            productRepository.save(p);
            return "Stock updated";
        } else {
            return "Product not found";
        }
    }

    @PostMapping(path = "/addCustomer")
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