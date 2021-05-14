package com.course.kafka.command.action;

import com.course.kafka.api.request.WebColorVoteRequest;
import com.course.kafka.broker.message.WebColorVoteMessage;
import com.course.kafka.broker.producer.WebColorVoteProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WebColorVoteAction
{
    private final WebColorVoteProducer producer;

    public void publishToKafka(WebColorVoteRequest request) {
        WebColorVoteMessage message = WebColorVoteMessage.builder()
                                                         .username(request.getUsername())
                                                         .color(request.getColor())
                                                         .voteDateTime(request.getVoteDateTime())
                                                         .build();

        producer.produce(message);
    }
}
