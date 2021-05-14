package com.course.kafka.command.service;

import com.course.kafka.api.request.WebLayoutVoteRequest;
import com.course.kafka.command.action.WebLayoutVoteAction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WebLayoutVoteService
{
    private final WebLayoutVoteAction action;

    public void createLayoutVote(WebLayoutVoteRequest request) {
        action.publishToKafka(request);
    }

}
