package com.course.kafka.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderRequest
{
    private String orderLocation;

    private String creditCardNumber;

    private List<OrderItemRequest> orderItems;
}
