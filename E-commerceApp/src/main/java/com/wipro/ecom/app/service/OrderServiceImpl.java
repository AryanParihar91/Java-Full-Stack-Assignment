package com.wipro.ecom.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecom.app.dto.OrdersDto;
import com.wipro.ecom.app.entity.Customers;
import com.wipro.ecom.app.entity.Orders;
import com.wipro.ecom.app.repository.ICustomerRepository;
import com.wipro.ecom.app.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository repo;

	@Autowired
	private ICustomerRepository customerRepo;

	@Override
	public Orders saveOrder(OrdersDto o) {

		Orders order = new Orders();

		order.setOid(o.getOid());
		order.setStatus(o.getStatus());
		order.setOrderAmount(o.getOrderAmount());

		Customers customer = customerRepo.findById(o.getCustomerId())
				.orElseThrow(() -> new RuntimeException("Customer not found"));

		order.setCustomer(customer);

		return repo.save(order);

	}

	@Override
	public Orders updateOrder(OrdersDto o) {

		Orders order = repo.findById(o.getOid()).orElseThrow(() -> new RuntimeException("Order not found"));

		order.setStatus(o.getStatus());
		order.setOrderAmount(o.getOrderAmount());

		Customers customer = customerRepo.findById(o.getCustomerId())
				.orElseThrow(() -> new RuntimeException("Customer not found"));

		order.setCustomer(customer);

		return repo.save(order);

	}

	@Override
	public Orders getOrderById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Orders> getAllOrders() {
		return repo.findAll();
	}

	@Override
	public List<Orders> getByStatus(String status) {
		return repo.findByStatus(status);
	}

	@Override
	public List<Orders> getByTotalAmountGreaterThan(double amount) {
		return repo.findByOrderAmountGreaterThan(amount);
	}

	@Override
	public List<Orders> getByTotalAmountLessThan(double amount) {
		return repo.findByOrderAmountLessThan(amount);
	}

	@Override
	public List<Orders> getOrdersByCustomerId(int cid) {
		return repo.findByCustomerCid(cid);
	}

}
