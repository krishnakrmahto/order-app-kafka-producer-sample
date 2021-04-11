package com.course.kafka.entity;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Data
@Builder
public class OrderItem
{
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "id")
    private Order order;
}
