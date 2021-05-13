package com.course.kafka.command.service;

import com.course.kafka.api.request.OnlineOrderRequest;
import com.course.kafka.command.action.OnlineOrderAction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OnlineOrderService
{
    private final OnlineOrderAction action;

    public void saveOnlineOrder(OnlineOrderRequest request) {
        action.publishToKafka(request);
    }

}
