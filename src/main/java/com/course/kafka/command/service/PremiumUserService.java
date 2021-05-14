package com.course.kafka.command.service;

import com.course.kafka.api.request.PremiumUserRequest;
import com.course.kafka.command.action.PremiumUserAction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PremiumUserService
{
    private final PremiumUserAction action;

    public void createUser(PremiumUserRequest request)
    {
        action.publishToKafka(request);
    }

}
