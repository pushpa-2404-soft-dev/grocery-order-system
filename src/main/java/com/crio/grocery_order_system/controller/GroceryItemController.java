package com.crio.grocery_order_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.crio.grocery_order_system.entity.GroceryItem;
import com.crio.grocery_order_system.service.GroceryItemService;

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