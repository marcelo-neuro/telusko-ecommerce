package com.marcelo_neuro.telusko_ecommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {

    private String orderId;
    private String customerName;
    private String customerEmail;
    private String status;
    private LocalDate orderDate;
    private List<OrderItemResponseDTO> items;
}
