package com.example.furreverrfinds_backend1.service.impl;

import com.example.furreverrfinds_backend1.dto.ReviewDto;
import com.example.furreverrfinds_backend1.entity.Content;
import com.example.furreverrfinds_backend1.entity.Review;
import com.example.furreverrfinds_backend1.entity.User;
import com.example.furreverrfinds_backend1.repository.ContentRepo;
import com.example.furreverrfinds_backend1.repository.ReviewRepo;
import com.example.furreverrfinds_backend1.repository.UserRepo;
import com.example.furreverrfinds_backend1.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;
    private final UserRepo userRepo;
    private final ContentRepo contentRepo;

    @Override
    public void save(ReviewDto reviewDto) {
        Review review;

        if (reviewDto.getId() != null) {
            review = reviewRepo.findById(reviewDto.getId()).get();
        } else {
            review = new Review();
        }

        Content content = contentRepo.findById(reviewDto.getContentId()).get();
        User user = userRepo.findById(reviewDto.getUserId()).get();


        review.setContent(content);
        review.setUserId(user);
        review.setRate(reviewDto.getRate());

        reviewRepo.save(review);
    }




    @Override
    public Integer getReviewByContentId(Long content_id) {
        return reviewRepo.getReviewByContentId(content_id);
    }
}

