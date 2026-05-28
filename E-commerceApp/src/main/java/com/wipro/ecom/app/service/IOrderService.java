package com.wipro.ecom.app.service;

import java.util.List;

import com.wipro.ecom.app.dto.OrdersDto;
import com.wipro.ecom.app.entity.Orders;

public interface IOrderService {

	Orders saveOrder(OrdersDto order);

	Orders updateOrder(OrdersDto order);

	Orders getOrderById(int id);

	List<Orders> getAllOrders();

	List<Orders> getByStatus(String status);

	List<Orders> getByTotalAmountGreaterThan(double amount);

	List<Orders> getByTotalAmountLessThan(double amount);

	List<Orders> getOrdersByCustomerId(int cid);

}
