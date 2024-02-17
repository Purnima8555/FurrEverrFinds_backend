package com.example.furreverrfinds_backend1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContentDto {

    private Long id;

    @NotNull
    private String itemTitle;

    @NotNull
    private String itemPhoto;

    @NotNull
    private String itemPrice;

    @NotNull
    private String categoryType;

    @NotNull
    private String subcategoryType;

    @NotNull
    private String itemDescription;
}
