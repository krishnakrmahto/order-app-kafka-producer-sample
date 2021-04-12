package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.DiscountMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class DiscountProducer
{
    private final KafkaTemplate<String, DiscountMessage> kafkaTemplate;

    public void publish(DiscountMessage message)
    {
        kafkaTemplate.send("t.commodity.promotion.and.discount", message)
        .addCallback(result -> log.info("DiscountMessage published successfully, result: {}", result),
                     e -> log.error("Error while publishing DiscountMessage: {}", message, e));
    }
}
