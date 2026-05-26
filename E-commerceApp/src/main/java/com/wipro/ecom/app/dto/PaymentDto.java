package com.wipro.ecom.app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PaymentDto {

	@Min(value = 1, message = "Payment ID must be greater than 0")
	private int ptid;

	@NotBlank(message = "Payment mode is required")
	private String paymentMode;

	@Positive(message = "Amount must be greater than 0")
	private double amount;

	@NotBlank(message = "Payment status is required")
	private String status;

}
