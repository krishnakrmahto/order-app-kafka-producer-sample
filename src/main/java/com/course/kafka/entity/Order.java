package com.course.kafka.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order")
@Data
@Builder
@NoArgsConstructor
public class Order
{
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, length = 20)
    private String orderNumber;

    @Column(nullable = false, length = 200)
    private String orderLocation;

    @Column(nullable = false)
    private LocalDateTime orderDateTime;

    @Column(nullable = false, length = 20)
    private String creditCardNumber;

    @OneToMany(fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;
}
