package com.merceariacau.groceryStoreApp.service;

import com.merceariacau.groceryStoreApp.application.exceptions.ProductNotFoundException;
import com.merceariacau.groceryStoreApp.controller.model.Product;
import com.merceariacau.groceryStoreApp.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    private ProductService service;

    @BeforeEach
    void setUp(){
        service = new ProductService();
    }

    @Disabled
    @Test
    void shouldCreateProductInDataBase() {
        var product = buildProductModel();

        service.createProduct(product);

        verify(repository.save(any()));
    }

    @Disabled
    @Test
    void shouldGetProductInDataBase() throws ProductNotFoundException {
        var product = buildProductModel();

        service.getProduct(product.getId());

        verify(repository.findById(any()));
    }

    @Disabled
    @Test
    void shouldUpdateProductInDataBase() {
        var product = buildProductModel();

        service.updateProduct(product);

        verify(repository.save(any()));
    }

    @Disabled
    @Test
    void shouldDeleteProductInDataBase() {
        var product = buildProductModel();

        service.deleteProduct(product.getId());

//        verify(repository.deleteById(product.getId()));
    }

    @Disabled
    @Test
    void shouldThrowExceptionIfTryToGetProductAndItNotExist() throws Exception{
        var product = buildProductModel();

        when(repository.getReferenceById(any())).thenThrow(new ProductNotFoundException());

        Assertions.assertThatThrownBy(() -> service.getProduct(product.getId()))
                .isInstanceOf(ProductNotFoundException.class)
                .hasMessage("Product Not Found.");
    }

    private static Product buildProductModel() {
        return Product.builder()
                .id(new UUID(10, 20))
                .description("description")
                .salePrice(30.0)
                .costPrice(10.0)
                .profitMargin(300.0)
                .tax(10.0)
                .quantity(2)
                .build();
    }
}