package com.course.kafka.command.service;

import com.course.kafka.api.request.DiscountRequest;
import com.course.kafka.command.action.DiscountAction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DiscountService
{
    private final DiscountAction action;

    public void createDiscount(DiscountRequest request)
    {
        action.publishToKafka(request);
    }
}
