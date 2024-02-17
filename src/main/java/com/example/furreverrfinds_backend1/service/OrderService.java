package com.example.furreverrfinds_backend1.service;


import com.example.furreverrfinds_backend1.dto.OrderDto;
import com.example.furreverrfinds_backend1.entity.Order;

import java.util.List;

public interface OrderService {
    void save(OrderDto orderDto);

    List<Order>getOrderByUserId(Long user_id);

    void deleteById(Long id);

    List<Order>getAllOrders();

    long getTotalSales();
}
