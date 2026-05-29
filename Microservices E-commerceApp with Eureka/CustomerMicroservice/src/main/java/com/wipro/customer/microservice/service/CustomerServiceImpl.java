package com.wipro.customer.microservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customer.microservice.dto.CustomerDto;
import com.wipro.customer.microservice.entity.Customer;
import com.wipro.customer.microservice.exception.CustomerNotFoundException;
import com.wipro.customer.microservice.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository repo;

	@Override
	public CustomerDto addCustomer(CustomerDto customerDto) {
		Customer customer = convertDtoToEntity(customerDto);

		Customer savedCustomer = repo.save(customer);
		return convertEntityToDto(savedCustomer);
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto) {

		Customer existingCustomer = repo.findById(customerDto.getCustomerId()).orElseThrow(
				() -> new CustomerNotFoundException("Customer not found with id: " + customerDto.getCustomerId()));

		existingCustomer.setCustomerName(customerDto.getCustomerName());
		existingCustomer.setEmail(customerDto.getEmail());

		existingCustomer.setAddress(customerDto.getAddress());

		Customer updatedCustomer = repo.save(existingCustomer);

		return convertEntityToDto(updatedCustomer);

	}

	@Override
	public void deleteCustomer(int customerId) {

		Customer existingCustomer = repo.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + customerId));

		repo.delete(existingCustomer);
	}

	@Override
	public CustomerDto getCustomerById(int customerId) {

		Customer customer = repo.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + customerId));

		return convertEntityToDto(customer);

	}

	@Override
	public List<CustomerDto> getAllCustomers() {

		List<Customer> customers = repo.findAll();

		return customers.stream().map(this::convertEntityToDto).collect(Collectors.toList());

	}

	@Override
	public List<CustomerDto> getCustomersByAddress(String address) {

		List<Customer> customers = repo.findByAddressIgnoreCase(address);

		if (customers.isEmpty()) {
			throw new CustomerNotFoundException("No customers found with address: " + address);
		}

		return customers.stream().map(this::convertEntityToDto).collect(Collectors.toList());

	}

	@Override
	public CustomerDto getCustomerByEmail(String email) {

		Customer customer = repo.findByEmail(email)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found with email: " + email));

		return convertEntityToDto(customer);

	}

	private Customer convertDtoToEntity(CustomerDto customerDto) {

		Customer customer = new Customer();

		customer.setCustomerId(customerDto.getCustomerId());
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setEmail(customerDto.getEmail());
		customer.setAddress(customerDto.getAddress());

		return customer;
	}

	private CustomerDto convertEntityToDto(Customer customer) {

		CustomerDto customerDto = new CustomerDto();

		customerDto.setCustomerId(customer.getCustomerId());
		customerDto.setCustomerName(customer.getCustomerName());
		customerDto.setEmail(customer.getEmail());
		customerDto.setAddress(customer.getAddress());

		return customerDto;
	}
}
