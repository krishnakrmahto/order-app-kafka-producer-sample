package com.course.kafka.command.action;

import com.course.kafka.api.request.DiscountRequest;
import com.course.kafka.broker.message.DiscountMessage;
import com.course.kafka.broker.producer.DiscountProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DiscountAction
{
    private final DiscountProducer producer;

    public void publishToKafka(DiscountRequest request)
    {
        producer.publish(new DiscountMessage(request.getDiscountCode(), request.getDiscountPercentage()));
    }
}
