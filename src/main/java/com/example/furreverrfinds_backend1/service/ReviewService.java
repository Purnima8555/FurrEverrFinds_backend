package com.example.furreverrfinds_backend1.service;

import com.example.furreverrfinds_backend1.dto.ReviewDto;

public interface ReviewService {
    void save(ReviewDto reviewDto);

    Integer getReviewByContentId(Long content_id);

}
