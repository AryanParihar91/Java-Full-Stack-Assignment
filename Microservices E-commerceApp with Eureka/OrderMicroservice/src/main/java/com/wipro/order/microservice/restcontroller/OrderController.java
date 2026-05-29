package com.wipro.order.microservice.restcontroller;

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

import com.wipro.order.microservice.dto.OrderDto;
import com.wipro.order.microservice.dto.OrderResponseDto;
import com.wipro.order.microservice.entity.Orders;
import com.wipro.order.microservice.service.IOrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private IOrderService service;

    @PostMapping(value = "/place", consumes = "application/json", produces = "application/json")
    public Orders placeOrder(@RequestBody @Valid OrderDto dto) {
        return service.placeOrder(dto);
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public Orders updateOrder(@RequestBody @Valid OrderDto dto) {
        return service.updateOrder(dto);
    }

    @DeleteMapping("/delete/{orderId}")
    public String deleteOrder(@PathVariable int orderId) {
        service.deleteOrder(orderId);
        return "Order deleted successfully with id: " + orderId;
    }

    @GetMapping(value = "/{orderId}", produces = "application/json")
    public Orders getOrderById(@PathVariable int orderId) {
        return service.getOrderById(orderId);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<Orders> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping(value = "/details/{orderId}", produces = "application/json")
    public OrderResponseDto getOrderWithDetails(@PathVariable int orderId) {
        return service.getOrderWithDetails(orderId);
    }

    @GetMapping(value = "/customer/{customerId}", produces = "application/json")
    public List<Orders> getOrdersByCustomerId(@PathVariable int customerId) {
        return service.getOrdersByCustomerId(customerId);
    }

    @GetMapping(value = "/product/{productId}", produces = "application/json")
    public List<Orders> getOrdersByProductId(@PathVariable int productId) {
        return service.getOrdersByProductId(productId);
    }

    @GetMapping(value = "/status/{orderStatus}", produces = "application/json")
    public List<Orders> getOrdersByStatus(@PathVariable String orderStatus) {
        return service.getOrdersByStatus(orderStatus);
    }
}