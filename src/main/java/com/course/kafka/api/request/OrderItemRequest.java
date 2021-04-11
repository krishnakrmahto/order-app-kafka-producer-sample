package com.course.kafka.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderItemRequest
{
    private String itemName;

    private int price;

    private int quantity;
}
