package com.crio.grocery_order_system.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.crio.grocery_order_system.repository.GroceryItemRepository;
import com.crio.grocery_order_system.entity.GroceryItem;
import com.crio.grocery_order_system.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class GroceryItemService {

    private final GroceryItemRepository repository;

    public List<GroceryItem> getAll() {
        return repository.findAll();
    }

    public GroceryItem getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
    }

    public GroceryItem save(GroceryItem item) {
        return repository.save(item);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}