package com.cheise_proj.orderservice.controller;

import com.cheise_proj.orderservice.domain.model.Order;
import com.cheise_proj.orderservice.domain.service.OrderService;
import com.cheise_proj.orderservice.dto.APIResponseData;
import com.cheise_proj.orderservice.dto.OrderDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<?> index() {
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderDto data) {
        Order order = Order.builder().build();
        BeanUtils.copyProperties(data, order);
        APIResponseData<Object> apiResponseData = APIResponseData.builder()
                .data(orderService.createOrder(order))
                .build();
        return new ResponseEntity<>(apiResponseData, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<?> cancelOrder(@PathVariable("id") String orderId) {
        APIResponseData<?> apiResponseData = APIResponseData.builder()
                .data(orderService.cancelOrder(orderId))
                .build();
        return new ResponseEntity<>(apiResponseData, HttpStatus.OK);
    }
}
