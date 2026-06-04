package com.wipro.order.microservice.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    @Min(value = 1, message = "Order ID must be greater than 0")
    private int orderId;

    @Min(value = 1, message = "Customer ID must be greater than 0")
    private int customerId;

    @Min(value = 1, message = "Product ID must be greater than 0")
    private int productId;

    @Positive(message = "Quantity must be greater than 0")
    private int quantity;
}