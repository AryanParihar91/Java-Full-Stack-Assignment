package com.wipro.order.microservice.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.order.microservice.dto.CustomerDto;
import com.wipro.order.microservice.dto.OrderDto;
import com.wipro.order.microservice.dto.OrderResponseDto;
import com.wipro.order.microservice.dto.ProductDto;
import com.wipro.order.microservice.entity.Orders;
import com.wipro.order.microservice.exception.OrderNotFoundException;
import com.wipro.order.microservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    private final String CUSTOMER_SERVICE_URL = "http://CustomerMicroservice/api/customers/";
    private final String PRODUCT_SERVICE_URL = "http://ProductMicroservice/api/products/";

    @Override
    public Orders placeOrder(OrderDto dto) {

        CustomerDto customer = getCustomerFromCustomerService(dto.getCustomerId());

        ProductDto product = getProductFromProductService(dto.getProductId());

        if (product.getStock() < dto.getQuantity()) {
            throw new RuntimeException("Insufficient stock. Available stock: " + product.getStock());
        }

        double totalAmount = product.getPrice() * dto.getQuantity();

        Orders order = new Orders();

        order.setOrderId(dto.getOrderId());
        order.setCustomerId(customer.getCustomerId());
        order.setProductId(product.getProductId());
        order.setQuantity(dto.getQuantity());
        order.setTotalAmount(totalAmount);
        order.setOrderStatus("PLACED");
        order.setOrderDate(LocalDate.now());

        return repo.save(order);
    }

    @Override
    public Orders updateOrder(OrderDto dto) {

        Orders existingOrder = repo.findById(dto.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException(
                        "Order not found with id: " + dto.getOrderId()
                ));

        CustomerDto customer = getCustomerFromCustomerService(dto.getCustomerId());

        ProductDto product = getProductFromProductService(dto.getProductId());

        if (product.getStock() < dto.getQuantity()) {
            throw new RuntimeException("Insufficient stock. Available stock: " + product.getStock());
        }

        double totalAmount = product.getPrice() * dto.getQuantity();

        existingOrder.setCustomerId(customer.getCustomerId());
        existingOrder.setProductId(product.getProductId());
        existingOrder.setQuantity(dto.getQuantity());
        existingOrder.setTotalAmount(totalAmount);
        existingOrder.setOrderStatus("UPDATED");
        existingOrder.setOrderDate(LocalDate.now());

        return repo.save(existingOrder);
    }

    @Override
    public void deleteOrder(int orderId) {

        Orders existingOrder = repo.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(
                        "Order not found with id: " + orderId
                ));

        repo.delete(existingOrder);
    }

    @Override
    public Orders getOrderById(int orderId) {

        return repo.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(
                        "Order not found with id: " + orderId
                ));
    }

    @Override
    public List<Orders> getAllOrders() {

        List<Orders> orders = repo.findAll();

        if (orders.isEmpty()) {
            throw new OrderNotFoundException("No orders found");
        }

        return orders;
    }

    @Override
    public OrderResponseDto getOrderWithDetails(int orderId) {

        Orders order = repo.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(
                        "Order not found with id: " + orderId
                ));

        CustomerDto customer = getCustomerFromCustomerService(order.getCustomerId());

        ProductDto product = getProductFromProductService(order.getProductId());

        return new OrderResponseDto(order, customer, product);
    }

    @Override
    public List<Orders> getOrdersByCustomerId(int customerId) {

        List<Orders> orders = repo.findByCustomerId(customerId);

        if (orders.isEmpty()) {
            throw new OrderNotFoundException("No orders found for customer id: " + customerId);
        }

        return orders;
    }

    @Override
    public List<Orders> getOrdersByProductId(int productId) {

        List<Orders> orders = repo.findByProductId(productId);

        if (orders.isEmpty()) {
            throw new OrderNotFoundException("No orders found for product id: " + productId);
        }

        return orders;
    }

    @Override
    public List<Orders> getOrdersByStatus(String orderStatus) {

        List<Orders> orders = repo.findByOrderStatusIgnoreCase(orderStatus);

        if (orders.isEmpty()) {
            throw new OrderNotFoundException("No orders found with status: " + orderStatus);
        }

        return orders;
    }

    private CustomerDto getCustomerFromCustomerService(int customerId) {

        String customerUrl = CUSTOMER_SERVICE_URL + customerId;

        return restTemplate.getForObject(customerUrl, CustomerDto.class);
    }

    private ProductDto getProductFromProductService(int productId) {

        String productUrl = PRODUCT_SERVICE_URL + productId;

        return restTemplate.getForObject(productUrl, ProductDto.class);
    }
}