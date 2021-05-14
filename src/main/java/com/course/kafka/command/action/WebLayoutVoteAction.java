package com.course.kafka.command.action;

import com.course.kafka.api.request.WebLayoutVoteRequest;
import com.course.kafka.broker.message.WebLayoutVoteMessage;
import com.course.kafka.broker.producer.WebLayoutVoteProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WebLayoutVoteAction
{
    private final WebLayoutVoteProducer producer;

    public void publishToKafka(WebLayoutVoteRequest request) {

        WebLayoutVoteMessage message = WebLayoutVoteMessage.builder()
                                                         .layout(request.getLayout())
                                                         .username(request.getUsername())
                                                         .voteDateTime(request.getVoteDateTime())
                                                         .build();

        producer.produce(message);
    }

}
