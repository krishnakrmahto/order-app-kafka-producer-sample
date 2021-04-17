package com.course.kafka.broker.consumer;

import com.course.kafka.broker.message.OrderReplyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderReplyConsumer
{
    @KafkaListener(topics = "t.commodity.order-reply")
    public void consume(OrderReplyMessage message)
    {
        log.info("Consuming reply message: {}", message);
    }
}
