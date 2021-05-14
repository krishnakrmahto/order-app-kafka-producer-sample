package com.course.kafka.command.action;

import com.course.kafka.api.request.PremiumUserRequest;
import com.course.kafka.broker.message.PremiumUserMessage;
import com.course.kafka.broker.producer.PremiumUserProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PremiumUserAction
{
    private final PremiumUserProducer producer;

    public void publishToKafka(PremiumUserRequest request)
    {
        producer.publish(new PremiumUserMessage(request.getUsername(), request.getLevel()));
    }
}
