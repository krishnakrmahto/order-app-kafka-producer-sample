package com.course.kafka.command.action;

import com.course.kafka.api.request.OnlinePaymentRequest;
import com.course.kafka.broker.message.OnlinePaymentMessage;
import com.course.kafka.broker.producer.OnlinePaymentProducer;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@AllArgsConstructor
public class OnlinePaymentAction
{
    private final OnlinePaymentProducer producer;

    public void publishPaymentToKafka(OnlinePaymentRequest request) {
        OnlinePaymentMessage message =
                OnlinePaymentMessage.builder()
                                    .onlineOrderNumber(request.getOnlineOrderNumber())
                                    .paymentNumber("PAY-" + RandomStringUtils.randomAlphanumeric(6).toUpperCase())
                                    .paymentDateTime(Optional.ofNullable(request.getPaymentDateTime()).orElse(LocalDateTime.now()))
                                    .paymentMethod(request.getPaymentMethod())
                                    .build();

        producer.publish(message);
    }

}
