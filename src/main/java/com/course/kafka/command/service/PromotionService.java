package com.course.kafka.command.service;

import com.course.kafka.api.request.PromotionRequest;
import com.course.kafka.command.action.PromotionAction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PromotionService
{
    private final PromotionAction action;

    public void createPromotion(PromotionRequest request)
    {
        action.publishToKafka(request);
    }
}
