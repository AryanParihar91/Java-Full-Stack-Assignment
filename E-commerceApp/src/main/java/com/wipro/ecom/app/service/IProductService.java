package com.wipro.ecom.app.service;

import java.util.List;

import com.wipro.ecom.app.dto.ProductsDto;
import com.wipro.ecom.app.entity.Products;


public interface IProductService {

	Products saveProduct(ProductsDto p);

	Products updateProduct(ProductsDto p);

	void deleteProduct(int id);

	Products getProductById(int id);

	List<Products> getAllProducts();

	List<Products> getByName(String name);

	List<Products> getByPriceRange(double min, double max);

	List<Products> getByNameContaining(String keyword);

}
