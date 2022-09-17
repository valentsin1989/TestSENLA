package com.gmail.valentsin1989.test.controller;

import com.gmail.valentsin1989.test.service.OrderService;
import com.gmail.valentsin1989.test.service.model.AddOrderDTO;
import com.gmail.valentsin1989.test.service.model.AddedOrderDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/order/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addOrder(@Validated @RequestBody AddOrderDTO addOrderDTO) {
        AddedOrderDTO addedOrder = orderService.addOrder(addOrderDTO);
        if (addedOrder != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(addedOrder.getId());
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("message", "Order is not created."));
    }

}
