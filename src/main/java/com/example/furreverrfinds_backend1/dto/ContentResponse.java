package com.example.furreverrfinds_backend1.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContentResponse {
    private Long id;

    private String itemTitle;

    private String itemPhoto;

    private String itemPrice;

    private String categoryType;

    private String subcategoryType;

    private String itemDescription;
}
