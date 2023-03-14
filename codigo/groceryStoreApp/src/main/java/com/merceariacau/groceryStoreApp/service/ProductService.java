package com.merceariacau.groceryStoreApp.service;

import java.util.UUID;

import com.merceariacau.groceryStoreApp.application.exceptions.ProductNotFoundException;
import com.merceariacau.groceryStoreApp.application.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    
    public Product getProduct(UUID productId) throws ProductNotFoundException{
    	return repository.findById(productId).orElseThrow(ProductNotFoundException::new);
    }

    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    @Transactional
    public void deleteProduct(UUID productId) {
        repository.deleteById(productId);
    }
}
