package com.merceariacau.groceryStoreApp.controller.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "Stock")
public class Stock {
	@Column(name = "PRODUCT_LIST", length = 10, nullable = false)
	private static List<Product> productList;
	@Column(name = "TOTAL_SELL", length = 10, nullable = false)
	private static Double totalSell;
	@Column(name = "UNDER_STOCK_PRODUCT_LIST", length = 10, nullable = false)
	private static List<Product> underStockProductList;

	public static void removeProduct(Product product) {
		productList.remove(product);
	}
	
	public static void removeProductById(UUID productId) {
		productList.forEach(product -> {
			if(product.getId().equals(productId)) {
				productList.remove(product);
			}
		});
	}

	public static void addProduct(Product product) {
		productList.add(product);
	}

	public static void updateProduct(Product product) {
		productList.forEach(oldProduct -> {
			if (oldProduct.getId().equals(product.getId())) {
				productList.remove(oldProduct);
				productList.add(product);
			}
		});
	}
}
