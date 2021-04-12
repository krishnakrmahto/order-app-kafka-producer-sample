package com.course.kafka.command.action;

import com.course.kafka.api.request.PromotionRequest;
import com.course.kafka.broker.message.PromotionMessage;
import com.course.kafka.broker.producer.PromotionProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PromotionAction
{
    private final PromotionProducer producer;

    public void publishToKafka(PromotionRequest request)
    {
        producer.publish(new PromotionMessage(request.getPromotionCode()));
    }
}
