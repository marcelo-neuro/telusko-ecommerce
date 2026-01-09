package com.marcelo_neuro.telusko_ecommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequestDTO {

    private Long productId;
    private Integer quantity;
}
