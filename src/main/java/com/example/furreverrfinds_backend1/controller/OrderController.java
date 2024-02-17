package com.example.furreverrfinds_backend1.controller;

import com.example.furreverrfinds_backend1.dto.OrderDto;
import com.example.furreverrfinds_backend1.entity.Order;
import com.example.furreverrfinds_backend1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping("/save")
    public String save(@RequestBody OrderDto orderDto) {
        orderService.save(orderDto);
        return "Data saved";
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/user/{user_id}")
    public List<Order> getOrderByUserId(@PathVariable("user_id") Long user_id){
        return orderService.getOrderByUserId(user_id);
    }

    @DeleteMapping("/{order_id}")
    public String deleteOrder(@PathVariable("order_id") Long id) {
        orderService.deleteById(id);
        return "Order deleted";
    }

    @GetMapping("/sales")
    public long getTotalSales() {
        return orderService.getTotalSales();
    }

}
