package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.PremiumPurchaseMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PremiumPurchaseProducer
{
    private final KafkaTemplate<String, PremiumPurchaseMessage> kafkaTemplate;

    public void produce(PremiumPurchaseMessage message)
    {
        kafkaTemplate.send("t.commodity.premium-purchase", message.getPurchaseNumber(), message);
    }

}
