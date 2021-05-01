package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.InventoryMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryProducer
{
    private final KafkaTemplate<String, InventoryMessage> kafkaTemplate;

    public void publish(InventoryMessage message)
    {
        kafkaTemplate.send("t.commodity.inventory", message.getItem(), message);
    }

}
