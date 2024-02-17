package com.example.furreverrfinds_backend1.repository;

import com.example.furreverrfinds_backend1.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepo extends JpaRepository<Content, Long> {

    @Query(value = "select * from content where category_type=?1", nativeQuery = true)
    List<Content> searchByCategory(String category);

    long count();
}
