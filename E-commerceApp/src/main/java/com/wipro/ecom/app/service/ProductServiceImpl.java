package com.wipro.ecom.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecom.app.dto.ProductsDto;
import com.wipro.ecom.app.entity.Products;
import com.wipro.ecom.app.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository repo;

	@Override
	public Products saveProduct(ProductsDto p) {

		Products product = new Products();

		product.setPid(p.getPid());
		product.setPname(p.getPname());
		product.setPrice(p.getPrice());

		return repo.save(product);

	}

	@Override
	public Products updateProduct(ProductsDto p) {
		Products product = new Products();

		product.setPid(p.getPid());
		product.setPname(p.getPname());
		product.setPrice(p.getPrice());

		return repo.save(product);
	}

	@Override
	public void deleteProduct(int id) {
		repo.deleteById(id);
	}

	@Override
	public Products getProductById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Products> getAllProducts() {
		return repo.findAll();
	}

	@Override
	public List<Products> getByName(String name) {
		return repo.findByPname(name);
	}

	@Override
	public List<Products> getByPriceRange(double min, double max) {
		return repo.findByPriceBetween(min, max);
	}

	@Override
	public List<Products> getByNameContaining(String keyword) {
		return repo.findByPnameContaining(keyword);
	}

}
