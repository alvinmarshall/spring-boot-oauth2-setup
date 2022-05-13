package com.cheise_proj.orderservice.domain.service;

import com.cheise_proj.orderservice.common.OrderStatus;
import com.cheise_proj.orderservice.domain.model.Order;
import com.cheise_proj.orderservice.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private final OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order input) {
        input.setStatus(OrderStatus.PENDING);
        return orderRepository.save(input);
    }

    public Order cancelOrder(String orderId) {
        return orderRepository.findByOrderId(orderId)
                .orElseThrow(() -> new IllegalArgumentException("order not found"));
    }
}
