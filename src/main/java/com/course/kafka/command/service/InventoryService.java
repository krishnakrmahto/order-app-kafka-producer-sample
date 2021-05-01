package com.course.kafka.command.service;

import com.course.kafka.api.request.InventoryRequest;
import com.course.kafka.command.action.InventoryAction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class InventoryService
{

    private final InventoryAction action;

    public void addInventory(InventoryRequest request)
    {
        action.publishToKafka(request, "ADD");
    }

    public void subtractInventory(InventoryRequest request) {
        action.publishToKafka(request, "REMOVE");
    }

}
