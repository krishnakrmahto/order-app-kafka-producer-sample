package com.course.kafka.api.server;

import com.course.kafka.api.request.DiscountRequest;
import com.course.kafka.command.service.DiscountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/discounts")
@AllArgsConstructor
public class DiscountController
{
    private final DiscountService service;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> create(@RequestBody DiscountRequest request)
    {
        service.createDiscount(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(request.getDiscountCode());
    }
}
