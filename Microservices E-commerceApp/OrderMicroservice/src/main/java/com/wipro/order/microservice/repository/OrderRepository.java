package com.wipro.order.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.order.microservice.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findByCustomerId(int customerId);

    List<Orders> findByProductId(int productId);

    List<Orders> findByOrderStatusIgnoreCase(String orderStatus);
}