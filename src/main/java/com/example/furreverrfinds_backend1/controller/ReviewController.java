package com.example.furreverrfinds_backend1.controller;

import com.example.furreverrfinds_backend1.dto.ReviewDto;
import com.example.furreverrfinds_backend1.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;


    @PostMapping
    public String save(@RequestBody ReviewDto reviewDto) {
        reviewService.save(reviewDto);
        return "Data saved";
    }

    @GetMapping("/{content_id}")
    public Integer getReviewByContentId(@PathVariable("content_id") Long content_id){
        return reviewService.getReviewByContentId(content_id);
    }
}