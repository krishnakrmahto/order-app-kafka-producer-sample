package com.course.kafka.command.service;

import com.course.kafka.api.request.OrderRequest;
import com.course.kafka.command.action.OrderAction;
import com.course.kafka.entity.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService
{
    private final OrderAction action;

    public String saveOrder(OrderRequest request)
    {
        // 1. convert OrderRequest to Order
        Order order = action.convertToOrder(request);

        // 2. save the Order entity to database
        action.saveToDatabase(order);

        // 3. flatten order and order items as kafka message
        order.getOrderItems().forEach(action::publishToKafka);

        // 4. return order number
        return order.getOrderNumber();
    }
}
