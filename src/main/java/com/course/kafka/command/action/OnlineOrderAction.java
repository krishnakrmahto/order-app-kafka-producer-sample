package com.course.kafka.command.action;

import com.course.kafka.api.request.OnlineOrderRequest;
import com.course.kafka.broker.message.OnlineOrderMessage;
import com.course.kafka.broker.producer.OnlineOrderProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OnlineOrderAction
{
    private final OnlineOrderProducer producer;

    public void publishToKafka(OnlineOrderRequest request) {

        producer.publish(OnlineOrderMessage.builder()
                                           .onlineOrderNumber(request.getOnlineOrderNumber())
                                           .orderDateTime(request.getOrderDateTime())
                                           .totalAmount(request.getTotalAmount())
                                           .username(request.getUsername())
                                           .build());
    }
}
