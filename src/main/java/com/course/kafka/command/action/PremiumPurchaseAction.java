package com.course.kafka.command.action;

import com.course.kafka.api.request.PremiumPurchaseRequest;
import com.course.kafka.broker.message.PremiumPurchaseMessage;
import com.course.kafka.broker.producer.PremiumPurchaseProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PremiumPurchaseAction
{
    private final PremiumPurchaseProducer producer;

    public void publishToKafka(PremiumPurchaseRequest request)
    {
        producer.produce(PremiumPurchaseMessage.builder()
                              .username(request.getUsername())
                              .item(request.getItem())
                              .purchaseNumber(request.getPurchaseNumber())
                              .build());
    }

}
