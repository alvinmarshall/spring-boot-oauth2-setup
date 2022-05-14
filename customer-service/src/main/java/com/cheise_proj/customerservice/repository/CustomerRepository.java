package com.cheise_proj.customerservice.repository;

import com.cheise_proj.customerservice.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
