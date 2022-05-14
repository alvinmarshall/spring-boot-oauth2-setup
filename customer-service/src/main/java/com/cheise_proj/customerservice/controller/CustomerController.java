package com.cheise_proj.customerservice.controller;

import com.cheise_proj.customerservice.domain.service.CustomerService;
import com.cheise_proj.customerservice.dto.CreateCustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") String id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CreateCustomerDto input) {
        return ResponseEntity.ok(customerService.createCustomer(input));
    }


}
