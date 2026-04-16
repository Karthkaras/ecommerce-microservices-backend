package com.karthik.microservices.order_service.service;

import com.karthik.microservices.order_service.dto.ProductDTO;
import com.karthik.microservices.order_service.dto.UserDTO;
import com.karthik.microservices.order_service.feign.ProductClient;
import com.karthik.microservices.order_service.feign.UserClient;
import com.karthik.microservices.order_service.model.Order;
import com.karthik.microservices.order_service.repository.OrderRepository;
import com.karthik.microservices.order_service.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userClient;
    private final ProductClient productClient;

    // Place new order
    public Order placeOrder(
            OrderRequest request) {

        // 1. Validate user exists
        UserDTO user = userClient
                .getUserById(request.getUserId());

        // 2. Validate product & get price
        ProductDTO product = productClient
                .getProductById(request.getProductId());

        // 3. Reduce stock in Product Service
        productClient.reduceStock(
                request.getProductId(),
                request.getQuantity());

        // 4. Create order
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setProductId(
                request.getProductId());
        order.setQuantity(request.getQuantity());
        order.setTotalAmount(
                product.getPrice()
                        * request.getQuantity());
        order.setStatus("CONFIRMED");

        return orderRepository.save(order);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get orders by user
    public List<Order> getOrdersByUser(
            Long userId) {
        return orderRepository
                .findByUserId(userId);
    }

    // Get order by ID
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Order not found: " + id));
    }

    // Update order status
    public Order updateStatus(
            Long id, String status) {
        Order order = getOrderById(id);
        order.setStatus(status);
        return orderRepository.save(order);
    }
}