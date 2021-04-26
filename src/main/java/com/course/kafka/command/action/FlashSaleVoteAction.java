package com.course.kafka.command.action;

import com.course.kafka.api.request.FlashSaleVoteRequest;
import com.course.kafka.broker.message.FlashSaleVoteMessage;
import com.course.kafka.broker.producer.FlashSaleVoteProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FlashSaleVoteAction
{
	private final FlashSaleVoteProducer producer;

	public void publishToKafka(FlashSaleVoteRequest request)
	{
		FlashSaleVoteMessage message = FlashSaleVoteMessage.builder()
														   .customerId(request.getCustomerId())
														   .itemName(request.getItemName())
														   .build();
		producer.produce(message);
	}

}
