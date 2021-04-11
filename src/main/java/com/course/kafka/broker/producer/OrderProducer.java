package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.OrderMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderProducer
{
    private final KafkaTemplate<String, OrderMessage> kafkaTemplate;

    public void publish(OrderMessage message)
    {
        kafkaTemplate.send("t.commodity.order", message.getOrderNumber(), message);
    }
}
