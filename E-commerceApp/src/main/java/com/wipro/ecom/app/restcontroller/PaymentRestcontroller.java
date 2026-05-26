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

import com.wipro.ecom.app.dto.PaymentDto;
import com.wipro.ecom.app.entity.Payment;
import com.wipro.ecom.app.exceptions.PaymentNotFoundException;
import com.wipro.ecom.app.service.IPaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/payment")
public class PaymentRestcontroller {

	@Autowired
	IPaymentService service;

	@PostMapping("/add")
	public Payment savePayment(@RequestBody @Valid PaymentDto p) {
		return service.savePayment(p);
	}

	@PutMapping("/update")
	public Payment updatePayment(@RequestBody @Valid PaymentDto p) {
		return service.updatePayment(p);
	}

	@GetMapping("/{id}")
	public Payment getById(@PathVariable int id) {

		Payment p = service.getPaymentById(id);

		if (p == null) {
			throw new PaymentNotFoundException("Payment not found with id: " + id);
		}
		return p;

	}

	@GetMapping("/all")
	public List<Payment> getAllPayments() {
		return service.getAllPayments();
	}

	@GetMapping("/amount/greaterthan/{amount}")
	public List<Payment> getGreaterThan(@PathVariable double amount) {
		return service.getAmountGreaterThan(amount);
	}

	@GetMapping("/amount/lessthan/{amount}")
	public List<Payment> getLessThan(@PathVariable double amount) {
		return service.getAmountLessThan(amount);
	}

	@GetMapping("/status/{status}")
	public List<Payment> getByStatus(@PathVariable String status) {
		return service.getByStatus(status);
	}

}
