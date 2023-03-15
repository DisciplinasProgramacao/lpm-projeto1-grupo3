package com.merceariacau.groceryStoreApp.controller;

import com.merceariacau.groceryStoreApp.application.exceptions.ProductNotFoundException;
import com.merceariacau.groceryStoreApp.controller.model.Product;
import com.merceariacau.groceryStoreApp.service.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class ProductControllerTest {

    @Mock
    private ProductService service;

    @InjectMocks
    private ProductController controller;

    @Test
    void shouldCreateProductAndReturnHttpStatusCreated() {
        Product product = buildProductModel();

        when(service.createProduct(any())).thenReturn(product);

        var expectedResponse = controller.createProduct(product);

        Assertions.assertThat(expectedResponse.getBody()).usingRecursiveComparison().isEqualTo(product);
        Assertions.assertThat(expectedResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void shouldGetProductAndReturnHttpStatusOk() throws ProductNotFoundException {
        Product product = buildProductModel();

        when(service.getProduct(any())).thenReturn(product);

        var expectedResponse = controller.getProduct(product.getId());

        Assertions.assertThat(expectedResponse.getBody()).usingRecursiveComparison().isEqualTo(product);
        Assertions.assertThat(expectedResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldUpdateProductAndReturnHttpStatusCreated() {
        Product product = buildProductModel();

        when(service.updateProduct(any())).thenReturn(product);

        var expectedResponse = controller.updateProduct(product);

        Assertions.assertThat(expectedResponse.getBody()).usingRecursiveComparison().isEqualTo(product);
        Assertions.assertThat(expectedResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void shouldDeleteProductAndReturnHttpStatusOk() {
        Product product = buildProductModel();

        var expectedResponse = controller.deleteProduct(product.getId());

        Assertions.assertThat(expectedResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    private static Product buildProductModel() {
        return Product.builder()
                .id(new UUID(10, 20))
                .description("description")
                .salePrice(30.0)
                .costPrice(10.0)
                .profitMargin(300.0)
                .tax(10.0)
                .build();
    }
}