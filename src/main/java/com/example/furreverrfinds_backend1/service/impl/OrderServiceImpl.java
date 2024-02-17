package com.example.furreverrfinds_backend1.service.impl;


import com.example.furreverrfinds_backend1.dto.OrderDto;
import com.example.furreverrfinds_backend1.entity.Order;
import com.example.furreverrfinds_backend1.entity.Content;
import com.example.furreverrfinds_backend1.entity.User;
import com.example.furreverrfinds_backend1.repository.OrderRepo;
import com.example.furreverrfinds_backend1.repository.ContentRepo;
import com.example.furreverrfinds_backend1.repository.UserRepo;
import com.example.furreverrfinds_backend1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final ContentRepo contentRepo;

    @Override
    public void save(OrderDto orderDto) {
        Order order;

        if (orderDto.getId() != null) {
            order = orderRepo.findById(orderDto.getId()).orElse(new Order());
        } else {
            order = new Order();
        }

        Content content = contentRepo.findById(orderDto.getContentId()).orElse(null);
        User user = userRepo.findById(orderDto.getUserId()).orElse(null);

        // Ensure content and user are not null before setting them to order
        if (content != null && user != null) {
            order.setContent(content);
            order.setUserId(user);
            order.setLocation(orderDto.getLocation());
            order.setQuantity(orderDto.getQuantity());
            order.setTotalPrice(orderDto.getTotalPrice());
            order.setOrderTime(orderDto.getOrderTime());
            order.setPayment(orderDto.getPayment());

            orderRepo.save(order);
        } else {
            // Handle exception case where content or user is not found
            throw new IllegalArgumentException("Content or user not found");
        }
    }

    @Override
    public List<Order> getOrderByUserId(Long user_id) {
        return orderRepo.findOrderByUser_Id(user_id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        orderRepo.deleteById(id);
    }

    @Override
    public long getTotalSales() {
        return orderRepo.count();
    }

}
