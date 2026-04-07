package com.crio.grocery_order_system.repository;

import com.crio.grocery_order_system.entity.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {}