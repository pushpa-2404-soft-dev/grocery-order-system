package com.crio.grocery.order.system.service;


import jakarta.persistence.*;
import lombok.*;

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