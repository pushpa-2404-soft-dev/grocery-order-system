package com.crio.grocery_order_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.crio.grocery_order_system.entity.Order;
import com.crio.grocery_order_system.service.OrderService;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService service;

  @GetMapping
  public List<Order> getAll() {
    return service.getAll();
  }

  @PostMapping
  public Order createOrder(@RequestParam Long customerId,
      @RequestBody List<Long> itemIds) {
    return service.createOrder(customerId, itemIds);
  }
}