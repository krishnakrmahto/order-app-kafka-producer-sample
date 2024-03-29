package com.course.kafka.api.server;

import com.course.kafka.api.request.OnlinePaymentRequest;
import com.course.kafka.command.service.OnlinePaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment/online")
@AllArgsConstructor
public class OnlinePaymentController {

    private final OnlinePaymentService service;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> pay(@RequestBody OnlinePaymentRequest request) {
        service.pay(request);
        return ResponseEntity.ok().body("Valid payment for order : " + request.getOnlineOrderNumber());
    }

}
