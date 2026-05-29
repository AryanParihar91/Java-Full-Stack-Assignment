package com.wipro.product.microservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	@Min(value = 1, message = "Product ID must be greater than 0")
	private int productId;

	@NotBlank(message = "Product name is required")
	private String productName;

	@Positive(message = "Product price must be greater than 0")
	private double price;

	@PositiveOrZero(message = "Product stock cannot be negative")
	private int stock;
}