package com.shop.rohmat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.rohmat.dtos.ProductDto;
import com.shop.rohmat.mappers.ProductMapper;
import com.shop.rohmat.model.Product;
import com.shop.rohmat.repository.ProductRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public @ResponseBody Iterable<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(product -> productMapper.toDto(product))
                .toList();
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

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductDto> GetProductById(@PathVariable Integer id) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productMapper.toDto(product));
    }
}
