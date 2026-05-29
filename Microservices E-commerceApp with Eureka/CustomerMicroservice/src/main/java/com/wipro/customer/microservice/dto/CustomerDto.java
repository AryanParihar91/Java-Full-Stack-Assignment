package com.wipro.customer.microservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomerDto {

	@Min(value = 1, message = "Customer ID must be greater than 0")
	private int customerId;

	@NotBlank(message = "Customer name is required")
	private String customerName;

	@NotBlank(message = "Email is required")
	@Email(message = "Email should be valid")
	private String email;

	@NotBlank(message = "Address is required")
	private String address;

}
