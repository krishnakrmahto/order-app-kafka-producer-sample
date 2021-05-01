package com.course.kafka.command.action;

import com.course.kafka.api.request.InventoryRequest;
import com.course.kafka.broker.message.InventoryMessage;
import com.course.kafka.broker.producer.InventoryProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InventoryAction
{
    private final InventoryProducer producer;

    public void publishToKafka(InventoryRequest request, String type)
    {
        InventoryMessage message = InventoryMessage.builder()
                                                 .location(request.getLocation())
                                                 .item(request.getItem())
                                                 .quantity(request.getQuantity())
                                                 .type(type)
                                                 .transactionTime(request.getTransactionTime())
                                                 .build();

        producer.publish(message);
    }
}
