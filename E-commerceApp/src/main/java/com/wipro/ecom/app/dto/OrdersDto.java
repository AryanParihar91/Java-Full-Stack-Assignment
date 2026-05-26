package com.wipro.ecom.app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OrdersDto {

@Min(value = 1, message = "Order ID must be greater than 0")
    private int oid;

    @NotBlank(message = "Order status is required")
    private String status;

    @Positive(message = "Order amount must be greater than 0")
    private double orderAmount;

}
