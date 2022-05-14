package com.cheise_proj.customerservice.domain.service;

import com.cheise_proj.customerservice.domain.model.Customer;
import com.cheise_proj.customerservice.dto.CreateCustomerDto;
import com.cheise_proj.customerservice.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("customer with id %s not found", id)));
    }

    public Customer createCustomer(CreateCustomerDto input) {
        Customer customer = Customer.builder().build();
        BeanUtils.copyProperties(input, customer);
        return customerRepository.save(customer);
    }
}
