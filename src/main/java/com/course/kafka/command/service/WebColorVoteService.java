package com.course.kafka.command.service;

import com.course.kafka.api.request.WebColorVoteRequest;
import com.course.kafka.command.action.WebColorVoteAction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WebColorVoteService
{
    private final WebColorVoteAction action;

    public void createColorVote(WebColorVoteRequest request)
    {
        action.publishToKafka(request);
    }
}
