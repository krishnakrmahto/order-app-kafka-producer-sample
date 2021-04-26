package com.course.kafka.command.service;

import com.course.kafka.api.request.FlashSaleVoteRequest;
import com.course.kafka.command.action.FlashSaleVoteAction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FlashSaleVoteService {

	private final FlashSaleVoteAction action;

	public void createFlashSaleVote(FlashSaleVoteRequest request) {
		action.publishToKafka(request);
	}

}
