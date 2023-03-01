package com.merceariacau.groceryStoreApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
	private String description;
	private Double salePrice;
	private Double costPrice;
	private Double profitMargin;
	private Double tax;
	
	public Product(String description, Double costPrice, Integer percentageProfitMargin) {
		this.description = description;
		this.costPrice = costPrice;
		this.profitMargin = calculateProfitMargin(percentageProfitMargin, costPrice);
		this.tax = calculateTaxValue(costPrice, profitMargin);
		this.salePrice = calculateSalePrice(costPrice, profitMargin, tax);
	}
	
	private Double calculateProfitMargin(Integer percentageProfitMargin, Double costPrice) {
		return profitMargin = (percentageProfitMargin/100) * costPrice; 
	}
	
	private Double calculateTaxValue(Double costPrice, Double profitMargin) {
		return tax = 0.18 * (costPrice + profitMargin);
	}
	
	private Double calculateSalePrice(Double costPrice, Double profitMargin, Double tax) {
		return salePrice = costPrice + profitMargin + tax;
	}
}
