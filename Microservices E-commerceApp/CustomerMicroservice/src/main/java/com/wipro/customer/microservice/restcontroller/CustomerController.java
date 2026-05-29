package com.wipro.customer.microservice.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.customer.microservice.dto.CustomerDto;
import com.wipro.customer.microservice.service.ICustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public CustomerDto addCustomer(@RequestBody @Valid CustomerDto dto) {
		return service.addCustomer(dto);
	}

	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public CustomerDto Customer(@RequestBody @Valid CustomerDto dto) {
		return service.updateCustomer(dto);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		service.deleteCustomer(customerId);
		return "Customer deleted successfully with id: " + customerId;
	}

	@GetMapping(value = "/{customerId}", produces = "application/json")
	public CustomerDto getCustomerById(@PathVariable int customerId) {
		return service.getCustomerById(customerId);
	}

	@GetMapping(value = "/all", produces = "application/json")
	public List<CustomerDto> getAllCustomers() {
		return service.getAllCustomers();
	}

	@GetMapping(value = "/address/{address}", produces = "application/json")
	public List<CustomerDto> getCustomersByAddress(@PathVariable String address) {
		return service.getCustomersByAddress(address);
	}

	@GetMapping(value = "/email/{email}", produces = "application/json")
	public CustomerDto getCustomerByEmail(@PathVariable String email) {
		return service.getCustomerByEmail(email);
	}

}
