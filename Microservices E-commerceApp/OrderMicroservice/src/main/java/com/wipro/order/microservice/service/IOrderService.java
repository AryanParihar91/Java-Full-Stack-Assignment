package com.wipro.order.microservice.service;

import java.util.List;

import com.wipro.order.microservice.dto.OrderDto;
import com.wipro.order.microservice.dto.OrderResponseDto;
import com.wipro.order.microservice.entity.Orders;

public interface IOrderService {

    Orders placeOrder(OrderDto orderDto);

    Orders updateOrder(OrderDto orderDto);

    void deleteOrder(int orderId);

    Orders getOrderById(int orderId);

    List<Orders> getAllOrders();

    OrderResponseDto getOrderWithDetails(int orderId);

    List<Orders> getOrdersByCustomerId(int customerId);

    List<Orders> getOrdersByProductId(int productId);

    List<Orders> getOrdersByStatus(String orderStatus);
}