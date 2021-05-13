package com.course.kafka.api.server;

import com.course.kafka.api.request.OnlineOrderRequest;
import com.course.kafka.command.service.OnlineOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order/online")
@AllArgsConstructor
public class OnlineOrderController
{
    private final OnlineOrderService service;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createOnlineOrder(@RequestBody OnlineOrderRequest request)
    {
        service.saveOnlineOrder(request);
        return ResponseEntity.ok().body("Saved online order " + request.getOnlineOrderNumber());
    }
}
