package com.example.furreverrfinds_backend1.service;

import com.example.furreverrfinds_backend1.dto.ContentDto;
import com.example.furreverrfinds_backend1.entity.Content;

import java.util.List;
import java.util.Optional;

public interface ContentService {

    List<Content> findAll();

    List<Content> searchByCategory(String category);

    Optional<Content> findById(Long id);

    void deleteById(Long id);

    void save(ContentDto contentDto);

    long getTotalCount();
}
