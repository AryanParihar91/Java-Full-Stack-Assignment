package com.wipro.product.microservice.service;

import java.util.List;

import com.wipro.product.microservice.dto.ProductDto;

public interface IProductService {

    ProductDto addProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto);

    void deleteProduct(int productId);

    ProductDto getProductById(int productId);

    List<ProductDto> getAllProducts();

    List<ProductDto> getProductsByPriceLessThanEqual(double price);

    List<ProductDto> getProductsInStock();
}