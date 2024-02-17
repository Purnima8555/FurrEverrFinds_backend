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
@Table(name = "orders")
public class Order {

    @Id
    @SequenceGenerator(name = "contents_seq_gen", sequenceName = "contents_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "contents_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "content_id", referencedColumnName = "id")
    private Content content;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "total_quantity", nullable = false)
    private String quantity;

    @Column(name = "total_Price", nullable = false)
    private String totalPrice;

    @Column(name = "order_DateTime", nullable = false)
    private String orderTime;

    @Column(name = "payment_Method", nullable = false)
    private String payment;

}
