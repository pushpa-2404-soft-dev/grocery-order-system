package com.crio.grocery_order_system.repository;

import com.crio.grocery_order_system.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}