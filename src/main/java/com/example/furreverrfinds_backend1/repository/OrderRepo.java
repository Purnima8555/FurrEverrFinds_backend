package com.example.furreverrfinds_backend1.repository;

import com.example.furreverrfinds_backend1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {


    @Query(value = "select * from orders where user_id=?1",nativeQuery = true)
    List<Order> findOrderByUser_Id(Long userId);

    long count();
}

