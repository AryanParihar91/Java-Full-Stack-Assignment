package com.wipro.ecom.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ecom.app.entity.Products;

public interface IProductRepository extends JpaRepository<Products, Integer> {

	List<Products> findByPname(String name);
	List<Products> findByPriceBetween(double min, double max);
	List<Products> findByPnameContaining(String keyword);

}
