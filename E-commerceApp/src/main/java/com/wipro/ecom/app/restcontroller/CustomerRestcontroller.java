package com.wipro.ecom.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.ecom.app.dto.CustomersDto;
import com.wipro.ecom.app.entity.Customers;
import com.wipro.ecom.app.exceptions.CustomerNotFoundException;
import com.wipro.ecom.app.service.ICustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestcontroller {

	@Autowired
	private ICustomerService service;

	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public Customers add(@RequestBody @Valid CustomersDto c) {
		return service.addCustomer(c);
	}

	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public Customers update(@RequestBody @Valid CustomersDto c) {
		return service.updateCustomer(c);
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public Customers getById(@PathVariable int id) {

		Customers c = service.getByCid(id);

		if (c == null) {
			throw new CustomerNotFoundException("Customer not found with id: " + id);
		}

		return c;

	}

	@GetMapping(value = "/getall", produces = "application/json")
	public List<Customers> getAll() {
		return service.getAllSorted();
	}

	@GetMapping("/address/{addr}")
	public List<Customers> getByAddress(@PathVariable String addr) {
		return service.getByAddress(addr);
	}
}
