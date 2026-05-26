package com.wipro.ecom.app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductsDto {

	@Min(value = 1, message = "Product ID must be greater than 0")
	private int pid;

	@NotBlank(message = "Product name is required")
	@Size(min = 2, max = 50, message = "Product name must be between 2 and 50 characters")
	private String pname;

	@Positive(message = "Price must be greater than 0")
	private double price;

	@Min(value = 0, message = "Quantity cannot be negative")
	private int quantity;

}