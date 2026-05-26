package com.wipro.ecom.app.service;

import java.util.List;

import com.wipro.ecom.app.dto.PaymentDto;
import com.wipro.ecom.app.entity.Payment;

public interface IPaymentService {

	Payment savePayment(PaymentDto p);

	Payment updatePayment(PaymentDto p);

	Payment getPaymentById(int id);

	List<Payment> getAllPayments();

	List<Payment> getAmountGreaterThan(double amount);

	List<Payment> getAmountLessThan(double amount);

	List<Payment> getByStatus(String status);

}
