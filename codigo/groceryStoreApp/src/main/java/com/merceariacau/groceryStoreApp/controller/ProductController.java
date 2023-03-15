package com.merceariacau.groceryStoreApp.controller;

import java.util.UUID;

import com.merceariacau.groceryStoreApp.application.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.merceariacau.groceryStoreApp.controller.model.Product;
import com.merceariacau.groceryStoreApp.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
    ProductService service;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        var response = service.createProduct(product);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<Product> getProduct(@RequestHeader UUID productId) throws ProductNotFoundException {
        var response = service.getProduct(productId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        var response = service.updateProduct(product);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(@RequestHeader UUID productId) {
    	service.deleteProduct(productId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
