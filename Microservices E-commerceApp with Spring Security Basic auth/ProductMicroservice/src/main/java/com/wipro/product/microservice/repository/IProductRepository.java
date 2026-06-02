package com.wipro.product.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.product.microservice.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByPriceLessThanEqual(double price);

    List<Product> findByStockGreaterThan(int stock);
}