package com.merceariacau.groceryStoreApp.controller;

import org.springframework.stereotype.Controller;

import com.merceariacau.groceryStoreApp.controller.model.Product;
import com.merceariacau.groceryStoreApp.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {

    ProductService service;
    
    public boolean createProduct(Product product){
        service.createProduct(product);

        return true;
    }

    public boolean updateProduct(Product product){
        service.updateProduct(product);

        return true;
    }

    public boolean deleteProduct(Product product){
        service.updateProduct(product);

        return true;
    }

}
