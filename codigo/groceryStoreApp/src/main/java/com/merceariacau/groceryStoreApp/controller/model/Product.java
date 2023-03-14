package com.merceariacau.groceryStoreApp.controller.model;

import java.util.UUID;

import com.merceariacau.groceryStoreApp.application.exceptions.DescriptionLengthException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.assertj.core.util.VisibleForTesting;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 11)
	private UUID id;
	@Column(name = "DESCRIPTION", length = 20, nullable = false)
	private String description;
	@Column(name = "SALE_PRICE", length = 10, nullable = false)
	private Double salePrice;
	@Column(name = "COST_PRICE", length = 10, nullable = false)
	private Double costPrice;
	@Column(name = "PROFIT_MARGIN", length = 10, nullable = false)
	private Double profitMargin;
	@Column(name = "TAX", length = 10, nullable = false)
	private Double tax;
	@Column(name = "QUANTITY", length = 10, nullable = false)
	private Integer quantity;

	public Product(String description, Double costPrice, Integer quantity, Integer percentageProfitMargin) {
		this.description = validateDescription(description);
		this.costPrice = costPrice;
		this.quantity = quantity;
		this.profitMargin = calculateProfitMargin(percentageProfitMargin, costPrice);
		this.tax = calculateTaxValue(costPrice, profitMargin);
		this.salePrice = calculateSalePrice(costPrice, profitMargin, tax);
	}

	@VisibleForTesting
	protected String validateDescription(String description) {
		if (description.length() < 3) {
			throw new DescriptionLengthException();
		}
		return description;
	}

	@VisibleForTesting
	protected Double calculateProfitMargin(Integer percentageProfitMargin, Double costPrice) {
		return profitMargin = (percentageProfitMargin / 100) * costPrice;
	}

	@VisibleForTesting
	protected Double calculateTaxValue(Double costPrice, Double profitMargin) {
		return tax = 0.18 * (costPrice + profitMargin);
	}

	@VisibleForTesting
	protected Double calculateSalePrice(Double costPrice, Double profitMargin, Double tax) {
		return salePrice = costPrice + profitMargin + tax;
	}
}
