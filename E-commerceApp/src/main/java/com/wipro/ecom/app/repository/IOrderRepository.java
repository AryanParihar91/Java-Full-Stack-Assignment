package com.wipro.ecom.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ecom.app.entity.Orders;

public interface IOrderRepository extends JpaRepository<Orders, Integer>{

	List<Orders> findByStatus(String status);

    List<Orders> findByOrderAmountGreaterThan(double amount);

    List<Orders> findByOrderAmountLessThan(double amount);


}
