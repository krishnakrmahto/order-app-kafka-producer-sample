package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.WebColorVoteMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WebColorVoteProducer
{
    private final KafkaTemplate<String, WebColorVoteMessage> kafkaTemplate;

    public void produce(WebColorVoteMessage message)
    {
        kafkaTemplate.send("t.commodity.web.vote-color", message.getUsername(), message);
    }
}
