package com.crio.grocery_order_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crio.grocery_order_system.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}