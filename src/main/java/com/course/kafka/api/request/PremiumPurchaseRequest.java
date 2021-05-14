package com.course.kafka.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PremiumPurchaseRequest
{
    private String item;

    private String purchaseNumber;

    private String username;
}
