package com.marcelo_neuro.telusko_ecommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

    private String customerName;
    private String customerEmail;
    private List<OrderItemRequestDTO> item;
}
