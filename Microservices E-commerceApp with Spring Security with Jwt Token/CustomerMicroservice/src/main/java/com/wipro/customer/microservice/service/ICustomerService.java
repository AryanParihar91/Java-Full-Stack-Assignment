package com.wipro.customer.microservice.service;

import java.util.List;

import com.wipro.customer.microservice.dto.CustomerDto;

public interface ICustomerService {

	CustomerDto addCustomer(CustomerDto customerDto);

	CustomerDto updateCustomer(CustomerDto customerDto);

	void deleteCustomer(int customerId);

	CustomerDto getCustomerById(int customerId);

	List<CustomerDto> getAllCustomers();

	List<CustomerDto> getCustomersByAddress(String address);

	CustomerDto getCustomerByEmail(String email);

}
