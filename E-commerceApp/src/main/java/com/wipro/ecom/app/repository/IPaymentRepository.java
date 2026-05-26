package com.wipro.ecom.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ecom.app.entity.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

	List<Payment> findByAmountGreaterThan(double amount);

	List<Payment> findByAmountLessThan(double amount);

	List<Payment> findByStatus(String status);

}
