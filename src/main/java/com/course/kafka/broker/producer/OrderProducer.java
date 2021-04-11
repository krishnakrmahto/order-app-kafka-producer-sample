package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.OrderMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class OrderProducer
{
    private final KafkaTemplate<String, OrderMessage> kafkaTemplate;

    public void publish(OrderMessage message)
    {
        kafkaTemplate.send("t.commodity.order", message.getOrderNumber(), message)
                     .addCallback(result -> log.info("Message sent successfully, message: {}, result: {}", message, result),
                                  e -> log.error("Error publishing message: {}", message, e));

        log.info("Message publish request has been sent for message:{}", message);
    }
}
