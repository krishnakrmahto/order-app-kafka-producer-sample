package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.FeedbackMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeedbackProducer
{
    private final KafkaTemplate<String, FeedbackMessage> kafkaTemplate;

    public void publish(FeedbackMessage message)
    {
        kafkaTemplate.send("t.commodity.feedback", message);
    }
}
