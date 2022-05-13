package com.cheise_proj.orderservice.domain.repository;

import com.cheise_proj.orderservice.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, String> {
    Optional<Order> findByOrderId(String orderId);
}
