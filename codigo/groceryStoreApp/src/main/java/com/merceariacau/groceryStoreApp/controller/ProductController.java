package com.merceariacau.groceryStoreApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Product> createProduct(Product product) {
        service.createProduct(product);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<Product> getProduct(Product product) {
        service.getClass(product);

        return true;
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(Product product) {
        service.updateProduct(product);

        return true;
    }

    @DeleteMapping
    public ResponseEntity<void> deleteProduct(Product product) {
        service.updateProduct(product);

        return true;
    }

}
