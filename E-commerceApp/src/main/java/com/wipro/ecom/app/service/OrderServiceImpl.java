package com.wipro.ecom.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecom.app.dto.OrdersDto;
import com.wipro.ecom.app.entity.Orders;
import com.wipro.ecom.app.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository repo;

	@Override
	public Orders saveOrder(OrdersDto o) {

		Orders order = new Orders();

		order.setOid(o.getOid());
		order.setStatus(o.getStatus());
		order.setOrderAmount(o.getOrderAmount());

		return repo.save(order);

	}

	@Override
	public Orders updateOrder(OrdersDto o) {
		Orders order = new Orders();

		order.setOid(o.getOid());
		order.setStatus(o.getStatus());
		order.setOrderAmount(o.getOrderAmount());

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

}
