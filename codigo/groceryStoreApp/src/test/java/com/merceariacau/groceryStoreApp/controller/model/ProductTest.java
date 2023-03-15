package com.merceariacau.groceryStoreApp.controller.model;

import com.merceariacau.groceryStoreApp.application.exceptions.DescriptionLengthException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith({MockitoExtension.class})
class ProductTest {

    @InjectMocks
    private Product productClass;

    @Test
    void shouldValidateDescription(){
        var validDescription = "Product01";

        var responseDescription = productClass.validateDescription(validDescription);

        Assertions.assertThat(responseDescription).isEqualTo(validDescription);
    }

    @Test
    void shouldCalculateProfitMargin(){
        var percentageProfitMargin = 200;
        var costPrice = 40.0;

        var expectedProfitMargin = (percentageProfitMargin / 100) * costPrice;

        var responseProfitMargin = productClass.calculateProfitMargin(percentageProfitMargin, costPrice);

        Assertions.assertThat(responseProfitMargin).isEqualTo(expectedProfitMargin);
    }

    @Test
    void shouldCalculateTaxValue(){
        var costPrice = 40.0;
        var profitMargin = 20.0;

        var expectedTax = 0.18 * (costPrice + profitMargin);

        var responseTax = productClass.calculateTaxValue(costPrice, profitMargin);

        Assertions.assertThat(expectedTax).isEqualTo(responseTax);
    }

    @Test
    void shouldCalculateSalePrice(){
        var costPrice = 40.0;
        var profitMargin = 20.0;
        var tax = 10.0;

        var expectedSalePrice = costPrice + profitMargin + tax;

        var responseSalePrice = productClass.calculateSalePrice(costPrice, profitMargin, tax);

        Assertions.assertThat(expectedSalePrice).isEqualTo(responseSalePrice);
    }

}