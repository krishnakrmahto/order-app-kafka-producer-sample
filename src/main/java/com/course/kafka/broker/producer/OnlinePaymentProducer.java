package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.OnlinePaymentMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OnlinePaymentProducer
{
    private final KafkaTemplate<String, OnlinePaymentMessage> kafkaTemplate;

    public void publish(OnlinePaymentMessage message)
    {
        kafkaTemplate.send("t.commodity.online-payment", message.getOnlineOrderNumber(), message);
    }
}
