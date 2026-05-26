package com.wipro.ecom.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecom.app.dto.PaymentDto;
import com.wipro.ecom.app.entity.Payment;
import com.wipro.ecom.app.repository.IPaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentRepository repo;

	@Override
	public Payment savePayment(PaymentDto p) {

		Payment pay = new Payment();

		pay.setPtid(p.getPtid());
		pay.setAmount(p.getAmount());
		pay.setStatus(p.getStatus());

		return repo.save(pay);

	}

	@Override
	public Payment updatePayment(PaymentDto p) {
		Payment pay = new Payment();

		pay.setPtid(p.getPtid());
		pay.setAmount(p.getAmount());
		pay.setStatus(p.getStatus());

		return repo.save(pay);
	}

	@Override
	public Payment getPaymentById(int ptid) {
		return repo.findById(ptid).orElse(null);
	}

	@Override
	public List<Payment> getAllPayments() {
		return repo.findAll();
	}

	@Override
	public List<Payment> getAmountGreaterThan(double amount) {
		return repo.findByAmountGreaterThan(amount);
	}

	@Override
	public List<Payment> getAmountLessThan(double amount) {
		return repo.findByAmountLessThan(amount);
	}

	@Override
	public List<Payment> getByStatus(String status) {
		return repo.findByStatus(status);
	}

}
