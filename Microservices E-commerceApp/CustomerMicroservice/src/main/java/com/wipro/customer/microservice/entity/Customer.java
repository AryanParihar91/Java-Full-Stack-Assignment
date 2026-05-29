package com.wipro.customer.microservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "customer_name", nullable = false)
	private String customerName;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String address;

}
