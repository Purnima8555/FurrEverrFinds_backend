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
@Table(name = "review")
public class Review {
    @Id
    @SequenceGenerator(name = "contents_seq_gen", sequenceName = "contents_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "contents_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id", referencedColumnName = "id")
    private Content content;


    @Column(name = "rate", nullable = false)
    private Integer rate;
}
