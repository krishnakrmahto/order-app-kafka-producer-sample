package com.course.kafka.command.service;

import com.course.kafka.api.request.PremiumPurchaseRequest;
import com.course.kafka.command.action.PremiumPurchaseAction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PremiumPurchaseService
{
    private final PremiumPurchaseAction action;

    public void createPurchase(PremiumPurchaseRequest request) {
        action.publishToKafka(request);
    }

}
