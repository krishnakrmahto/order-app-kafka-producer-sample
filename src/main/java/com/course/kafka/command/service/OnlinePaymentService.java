package com.course.kafka.command.service;

import com.course.kafka.api.request.OnlinePaymentRequest;
import com.course.kafka.command.action.OnlinePaymentAction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OnlinePaymentService
{
    private final OnlinePaymentAction action;

    public void pay(OnlinePaymentRequest request) {
        action.publishPaymentToKafka(request);
    }

}
