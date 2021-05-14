package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.PremiumUserMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PremiumUserProducer
{
    private final KafkaTemplate<String, PremiumUserMessage> kafkaTemplate;

    public void publish(PremiumUserMessage message)
    {
        kafkaTemplate.send("t.commodity.premium-user", message.getUsername(), message);
    }

}
