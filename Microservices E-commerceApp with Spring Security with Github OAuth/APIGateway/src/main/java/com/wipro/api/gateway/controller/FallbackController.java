package com.wipro.api.gateway.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @GetMapping("/fallback/customer")
    public Mono<ResponseEntity<Map<String, Object>>> customerFallback() {

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.SERVICE_UNAVAILABLE.value());
        response.put("error", "Customer Service Unavailable");
        response.put("message", "CustomerMicroservice is currently down or not responding. Please try again later.");

        return Mono.just(new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE));
    }

    @GetMapping("/fallback/product")
    public Mono<ResponseEntity<Map<String, Object>>> productFallback() {

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.SERVICE_UNAVAILABLE.value());
        response.put("error", "Product Service Unavailable");
        response.put("message", "ProductMicroservice is currently down or not responding. Please try again later.");

        return Mono.just(new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE));
    }

    @GetMapping("/fallback/order")
    public Mono<ResponseEntity<Map<String, Object>>> orderFallback() {

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.SERVICE_UNAVAILABLE.value());
        response.put("error", "Order Service Unavailable");
        response.put("message", "OrderMicroservice is currently down or not responding. Please try again later.");

        return Mono.just(new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE));
    }
}