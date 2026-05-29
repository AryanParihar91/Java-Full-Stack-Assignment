package com.wipro.order.microservice.dto;

import com.wipro.order.microservice.entity.Orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {

	private Orders order;
	private CustomerDto customer;
	private ProductDto product;
}
