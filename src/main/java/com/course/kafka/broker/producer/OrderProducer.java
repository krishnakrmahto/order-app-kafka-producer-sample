package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.OrderMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class OrderProducer
{
    private final KafkaTemplate<String, OrderMessage> kafkaTemplate;

    public void publish(OrderMessage message)
    {
        kafkaTemplate.send(buildProducerRecord(message))
                     .addCallback(result -> log.info("Message sent successfully, message: {}, result: {}", message, result),
                                  e -> log.error("Error publishing message: {}", message, e));

        log.info("Message publish request has been sent for message:{}", message);
    }

    private ProducerRecord<String, OrderMessage> buildProducerRecord(OrderMessage message)
    {
        int bonus = message.getOrderLocation().startsWith("A")? 25: 15;
        List<Header> headers = Collections.singletonList(new RecordHeader("surpriseBonus", String.valueOf(bonus).getBytes()));
        return new ProducerRecord<>("t.commodity.order", null, message.getOrderNumber(), message, headers);
    }
}
