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

import com.wipro.ecom.app.dto.OrdersDto;
import com.wipro.ecom.app.entity.Orders;
import com.wipro.ecom.app.exceptions.OrderNotFoundException;
import com.wipro.ecom.app.service.IOrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/order")
public class OrderRestcontroller {

	@Autowired
	private IOrderService service;

	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public Orders add(@RequestBody @Valid OrdersDto order) {
		return service.saveOrder(order);
	}

	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public Orders update(@RequestBody @Valid OrdersDto order) {
		return service.updateOrder(order);
	}

	@GetMapping("/{id}")
	public Orders getById(@PathVariable int id) {

		Orders o = service.getOrderById(id);

		if (o == null) {
			throw new OrderNotFoundException("Order not found with id: " + id);
		}

		return o;

	}

	@GetMapping("/all")
	public List<Orders> getAll() {
		return service.getAllOrders();
	}

	@GetMapping("/status/{status}")
	public List<Orders> getByStatus(@PathVariable String status) {
		return service.getByStatus(status);
	}

	@GetMapping("/amount/greaterthan/{amt}")
	public List<Orders> getByAmountGt(@PathVariable double amt) {
		return service.getByTotalAmountGreaterThan(amt);
	}

	@GetMapping("/amount/lessthan/{amt}")
	public List<Orders> getByAmountLt(@PathVariable double amt) {
		return service.getByTotalAmountLessThan(amt);
	}

	@GetMapping("/customer/{cid}")
	public List<Orders> getByCustomerId(@PathVariable int cid) {
		return service.getOrdersByCustomerId(cid);
	}

}
