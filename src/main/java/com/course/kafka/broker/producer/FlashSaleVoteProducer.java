package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.FlashSaleVoteMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FlashSaleVoteProducer
{
    private final KafkaTemplate<String, FlashSaleVoteMessage> kafkaTemplate;

    public void produce(FlashSaleVoteMessage message)
    {
        kafkaTemplate.send("t.commodity.flashsale.vote", message);
    }
}
