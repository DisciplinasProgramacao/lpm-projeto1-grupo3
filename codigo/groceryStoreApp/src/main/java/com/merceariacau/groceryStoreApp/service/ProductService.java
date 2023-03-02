package com.merceariacau.groceryStoreApp.service;

import org.springframework.stereotype.Service;
import com.merceariacau.groceryStoreApp.controller.model.Product;
import com.merceariacau.groceryStoreApp.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private ProductRepository repository;
    
    public boolean createProduct(Product product){
        return repository.createProduct(product);
    }

    public boolean updateProduct(Product product){
        return repository.updateProduct(product);
    }

    public boolean deleteProduct(Product product){
        return repository.updateProduct(product);
    }
}
