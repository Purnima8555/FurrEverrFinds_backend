package com.example.furreverrfinds_backend1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "content")
public class Content {

    @Id
    @SequenceGenerator(name = "contents_seq_gen", sequenceName = "contents_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "contents_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "item_title", nullable = false)
    private String itemTitle;

    @Column(name = "item_photo")
    private String itemPhoto;

    @Column(name = "item_price")
    private String itemPrice;

    @Column(name = "category_type")
    private String categoryType;

    @Column(name = "subcategory_type")
    private String subcategoryType;

    @Column(name = "item_description", length = 2000)
    private String itemDescription;

}
