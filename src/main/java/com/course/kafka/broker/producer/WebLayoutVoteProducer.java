package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.WebLayoutVoteMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WebLayoutVoteProducer
{
    private final KafkaTemplate<String, WebLayoutVoteMessage> kafkaTemplate;

    public void produce(WebLayoutVoteMessage message)
    {
        kafkaTemplate.send("t.commodity.web.vote-layout", message.getUsername(), message);
    }
}
