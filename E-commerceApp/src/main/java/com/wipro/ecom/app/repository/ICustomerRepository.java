package com.wipro.ecom.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ecom.app.entity.Customers;

public interface ICustomerRepository extends JpaRepository<Customers, Integer> {
	
	List<Customers> findByAddressIgnoreCase(String city);

}
