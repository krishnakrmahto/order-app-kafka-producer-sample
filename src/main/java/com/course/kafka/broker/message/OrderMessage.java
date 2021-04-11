package com.course.kafka.broker.message;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderMessage
{
    private int orderId;

    private String orderNumber;

    private String orderLocation;

    private LocalDateTime orderDateTime;

    private String creditCardNumber;

    private int id;

    private String name;

    private int price;

    private int quantity;
}
