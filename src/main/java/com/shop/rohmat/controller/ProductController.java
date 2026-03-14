package com.shop.rohmat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.rohmat.model.Product;
import com.shop.rohmat.repository.ProductRepository;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/products")
    public @ResponseBody Iterable<Product> getAllProducts() {
        return productRepository.findAll();
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

    @PostMapping(path = "/UpdateStock")
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
}
