package com.merceariacau.groceryStoreApp.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merceariacau.groceryStoreApp.controller.model.Product;
import com.merceariacau.groceryStoreApp.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
    private ProductRepository repository;

    public Product createProduct(Product product) {
        return repository.save(product);
    }
    
    public Product getProduct(UUID productId) {
    	return repository.findById(productId).orElseThrow();
    }

    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    @Transactional
    public void deleteProduct(UUID productId) {
        repository.deleteById(productId);
    }
}
