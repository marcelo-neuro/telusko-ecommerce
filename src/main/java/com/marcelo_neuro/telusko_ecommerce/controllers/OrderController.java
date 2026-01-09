package com.marcelo_neuro.telusko_ecommerce.controllers;

import com.marcelo_neuro.telusko_ecommerce.dtos.OrderRequestDTO;
import com.marcelo_neuro.telusko_ecommerce.dtos.OrderResponseDTO;
import com.marcelo_neuro.telusko_ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/orders/place")
    public ResponseEntity<OrderResponseDTO> add(@RequestBody OrderRequestDTO order) {
        return ResponseEntity.ok(service.add(order));
    }
}
