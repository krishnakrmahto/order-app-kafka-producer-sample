package com.course.kafka.command.service;

import com.course.kafka.api.request.FeedbackRequest;
import com.course.kafka.command.action.FeedbackAction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeedbackService {
    private final FeedbackAction action;

    public void createFeedback(FeedbackRequest request) {
        action.publishToKafka(request);
    }

}
