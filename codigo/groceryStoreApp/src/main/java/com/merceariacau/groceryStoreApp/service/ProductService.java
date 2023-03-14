package com.merceariacau.groceryStoreApp.service;

import org.springframework.stereotype.Service;

import com.merceariacau.groceryStoreApp.controller.model.Product;
import com.merceariacau.groceryStoreApp.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
public class ProductService {

    private ProductRepository repository;

    public Product createProduct(Product product) {
        return repository.createProduct(product);
    }
    
    public Product getProduct(Integer id) {
    	return repository.getProduct(id);
    }

    public Product updateProduct(Product product) {
        return repository.updateProduct(product);
    }

    public void deleteProduct(Product product) {
        return repository.updateProduct(product);
    }
}
