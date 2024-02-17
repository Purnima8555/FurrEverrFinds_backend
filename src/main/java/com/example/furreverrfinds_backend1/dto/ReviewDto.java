package com.example.furreverrfinds_backend1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ReviewDto {

    private Long id;


    private Integer userId;


    private Long contentId;


    private Integer rate;
}
