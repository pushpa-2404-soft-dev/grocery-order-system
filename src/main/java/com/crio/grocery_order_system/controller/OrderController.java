package com.crio.grocery.order.system.controller;

import lombok.*;

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