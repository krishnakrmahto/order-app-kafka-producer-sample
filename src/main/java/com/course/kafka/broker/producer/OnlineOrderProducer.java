package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.OnlineOrderMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OnlineOrderProducer
{
    private final KafkaTemplate<String, OnlineOrderMessage> kafkaTemplate;

    public void publish(OnlineOrderMessage message) {
        kafkaTemplate.send("t.commodity.online-order", message.getOnlineOrderNumber(), message);
    }
}
