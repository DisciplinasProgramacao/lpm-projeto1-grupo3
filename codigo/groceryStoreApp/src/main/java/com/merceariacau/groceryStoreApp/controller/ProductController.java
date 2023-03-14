package com.merceariacau.groceryStoreApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.merceariacau.groceryStoreApp.model.Product;
import com.merceariacau.groceryStoreApp.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
    ProductService service;
    
    
    @PostMapping
    public ResponseEntity<?> createProduct(Product product) {
        service.createProduct(product);

        return ResponseEntity<>();
    }
    
    @GetMapping
    public boolean getProduct(Product product) {
        service.updateProduct(product);

        return true;
    }

    @PutMapping
    public boolean updateProduct(Product product) {
        service.updateProduct(product);

        return true;
    }

    @DeleteMapping
    public boolean deleteProduct(Product product) {
        service.updateProduct(product);

        return true;
    }

}
