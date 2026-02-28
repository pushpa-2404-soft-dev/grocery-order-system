package com.crio.grocery.order.system.service;


import jakarta.persistence.*;
import lombok.*;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final GroceryItemRepository itemRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order createOrder(Long customerId, List<Long> itemIds) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        List<GroceryItem> items = itemRepository.findAllById(itemIds);

        double totalPrice = items.stream()
                .mapToDouble(GroceryItem::getPrice)
                .sum();

        Order order = new Order();
        order.setCustomer(customer);
        order.setItems(items);
        order.setOrderDate(LocalDate.now());
        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}