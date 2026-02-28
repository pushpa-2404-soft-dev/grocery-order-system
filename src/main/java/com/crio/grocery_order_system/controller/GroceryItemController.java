package com.crio.grocery.order.system.controller;

import lombok.*;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class GroceryItemController {

    private final GroceryItemService service;

    @GetMapping
    public List<GroceryItem> getAll() {
        return service.getAll();
    }

    @PostMapping
    public GroceryItem create(@RequestBody GroceryItem item) {
        return service.save(item);
    }
}