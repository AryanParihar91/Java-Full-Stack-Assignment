package com.wipro.product.microservice.restcontroller;

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

import com.wipro.product.microservice.dto.ProductDto;
import com.wipro.product.microservice.service.IProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService service;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ProductDto addProduct(@RequestBody @Valid ProductDto dto) {
        return service.addProduct(dto);
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ProductDto updateProduct(@RequestBody @Valid ProductDto dto) {
        return service.updateProduct(dto);
    }

    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        service.deleteProduct(productId);
        return "Product deleted successfully with id: " + productId;
    }

    @GetMapping(value = "/{productId}", produces = "application/json")
    public ProductDto getProductById(@PathVariable int productId) {
        return service.getProductById(productId);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<ProductDto> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping(value = "/price/{price}", produces = "application/json")
    public List<ProductDto> getProductsByPriceLessThanEqual(@PathVariable double price) {
        return service.getProductsByPriceLessThanEqual(price);
    }

    @GetMapping(value = "/instock", produces = "application/json")
    public List<ProductDto> getProductsInStock() {
        return service.getProductsInStock();
    }
}