package com.course.kafka.command.action;

import com.course.kafka.api.request.OrderItemRequest;
import com.course.kafka.api.request.OrderRequest;
import com.course.kafka.broker.message.OrderMessage;
import com.course.kafka.broker.producer.OrderProducer;
import com.course.kafka.entity.Order;
import com.course.kafka.entity.Order.OrderBuilder;
import com.course.kafka.entity.OrderItem;
import com.course.kafka.repository.OrderItemRepository;
import com.course.kafka.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OrderAction
{
    private final OrderProducer producer;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public Order convertToOrder(OrderRequest request)
    {

        OrderBuilder orderBuilder = Order.builder()
                                         .creditCardNumber(request.getCreditCardNumber())
                                         .orderLocation(request.getOrderLocation())
                                         .orderDateTime(LocalDateTime.now())
                                         .orderNumber(RandomStringUtils.randomAlphanumeric(8).toUpperCase());

        List<OrderItem> orderItems = request.getOrderItems().stream()
                                            .map(this::convertToOrderItem)
                                            .collect(Collectors.toList());

        Order order = orderBuilder.orderItems(orderItems).build();

        orderItems.forEach(orderItem -> orderItem.setOrder(order));

        return order;
    }

    private OrderItem convertToOrderItem(OrderItemRequest orderItemRequest)
    {
        return OrderItem.builder()
                        .name(orderItemRequest.getItemName())
                        .price(orderItemRequest.getPrice())
                        .quantity(orderItemRequest.getQuantity())
                        .build();
    }

    public void saveToDatabase(Order order)
    {
        orderRepository.save(order);
        order.getOrderItems().forEach(orderItemRepository::save);
    }

    public void publishToKafka(OrderItem orderItem)
    {
        Order order = orderItem.getOrder();

        OrderMessage orderMessage = OrderMessage.builder()
                                                .itemName(orderItem.getName())
                                                .price(orderItem.getPrice())
                                                .quantity(orderItem.getQuantity())
                                                .orderDateTime(order.getOrderDateTime())
                                                .orderLocation(order.getOrderLocation())
                                                .orderNumber(order.getOrderNumber())
                                                .creditCardNumber(order.getCreditCardNumber())
                                                .build();

        producer.publish(orderMessage);
    }
}
