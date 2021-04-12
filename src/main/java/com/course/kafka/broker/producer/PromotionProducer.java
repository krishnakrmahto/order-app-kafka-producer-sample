package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.PromotionMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class PromotionProducer
{
    private final KafkaTemplate<String, PromotionMessage> kafkaTemplate;

    public void publish(PromotionMessage message)
    {
            kafkaTemplate.send("t.commodity.promotion.and.discount", message)
                         .addCallback(result -> log.info("PromotionMessage has been published with result: {}", result),
                                      e -> log.error("Error while publishing PromotionMessage: {}", message, e));
    }
}
