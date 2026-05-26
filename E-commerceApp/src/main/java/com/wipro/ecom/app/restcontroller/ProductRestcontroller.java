package com.wipro.ecom.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.ecom.app.dto.ProductsDto;
import com.wipro.ecom.app.entity.Products;
import com.wipro.ecom.app.exceptions.ProductNotFoundException;
import com.wipro.ecom.app.service.IProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductRestcontroller {

	@Autowired
	private IProductService service;

	@PostMapping("/add")
	public Products saveProduct(@RequestBody @Valid ProductsDto p) {
		return service.saveProduct(p);
	}

	@PutMapping("/update")
	public Products updateProduct(@RequestBody @Valid ProductsDto p) {
		return service.updateProduct(p);
	}

	@GetMapping("/all")
	public List<Products> getAllProducts() {
		return service.getAllProducts();
	}

	@GetMapping("/{id}")
	public Products getProductById(@PathVariable int id) {

		Products p = service.getProductById(id);

		if (p == null) {
			throw new ProductNotFoundException("Product not found with id: " + id);
		}

		return p;

	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id) {

		Products p = service.getProductById(id);

		if (p == null) {
			throw new ProductNotFoundException("Product not found with id: " + id);
		}

		service.deleteProduct(id);
		return "Deleted Successfully";

	}

	@GetMapping("/name/{name}")
	public List<Products> getByName(@PathVariable String name) {
		return service.getByName(name);
	}

	@GetMapping("/range/{min}/{max}")
	public List<Products> getByRange(@PathVariable double min, @PathVariable double max) {
		return service.getByPriceRange(min, max);
	}

	@GetMapping("/search/{keyword}")
	public List<Products> search(@PathVariable String keyword) {
		return service.getByNameContaining(keyword);
	}

}
