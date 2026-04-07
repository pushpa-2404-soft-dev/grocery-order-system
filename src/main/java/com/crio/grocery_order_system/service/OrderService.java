package com.crio.grocery_order_system.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.time.LocalDate;
import com.crio.grocery_order_system.repository.OrderRepository;
import com.crio.grocery_order_system.repository.CustomerRepository;
import com.crio.grocery_order_system.repository.GroceryItemRepository;
import com.crio.grocery_order_system.entity.Customer;
import com.crio.grocery_order_system.entity.Order;
import com.crio.grocery_order_system.entity.GroceryItem;
import com.crio.grocery_order_system.exception.ResourceNotFoundException;

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