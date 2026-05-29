package com.wipro.product.microservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.product.microservice.dto.ProductDto;
import com.wipro.product.microservice.entity.Product;
import com.wipro.product.microservice.exception.ProductNotFoundException;
import com.wipro.product.microservice.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository repo;

	@Override
	public ProductDto addProduct(ProductDto dto) {

		Product product = convertDtoToEntity(dto);

		Product savedProduct = repo.save(product);

		return convertEntityToDto(savedProduct);
	}

	@Override
	public ProductDto updateProduct(ProductDto dto) {

		Product existingProduct = repo.findById(dto.getProductId()).orElseThrow(
				() -> new ProductNotFoundException("Product not found with id: " + dto.getProductId()));

		existingProduct.setProductName(dto.getProductName());
		existingProduct.setPrice(dto.getPrice());
		existingProduct.setStock(dto.getStock());

		Product updatedProduct = repo.save(existingProduct);

		return convertEntityToDto(updatedProduct);
	}

	@Override
	public void deleteProduct(int productId) {

		Product existingProduct = repo.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));

		repo.delete(existingProduct);
	}

	@Override
	public ProductDto getProductById(int productId) {

		Product product = repo.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));

		return convertEntityToDto(product);
	}

	@Override
	public List<ProductDto> getAllProducts() {

		List<Product> products = repo.findAll();

		return products.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getProductsByPriceLessThanEqual(double price) {

		List<Product> products = repo.findByPriceLessThanEqual(price);

		if (products.isEmpty()) {
			throw new ProductNotFoundException("No products found with price less than or equal to: " + price);
		}

		return products.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getProductsInStock() {

		List<Product> products = repo.findByStockGreaterThan(0);

		if (products.isEmpty()) {
			throw new ProductNotFoundException("No products available in stock");
		}

		return products.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	private Product convertDtoToEntity(ProductDto dto) {

		Product product = new Product();

		product.setProductId(dto.getProductId());
		product.setProductName(dto.getProductName());
		product.setPrice(dto.getPrice());
		product.setStock(dto.getStock());

		return product;
	}

	private ProductDto convertEntityToDto(Product product) {

		ProductDto dto = new ProductDto();

		dto.setProductId(product.getProductId());
		dto.setProductName(product.getProductName());
		dto.setPrice(product.getPrice());
		dto.setStock(product.getStock());

		return dto;
	}
}