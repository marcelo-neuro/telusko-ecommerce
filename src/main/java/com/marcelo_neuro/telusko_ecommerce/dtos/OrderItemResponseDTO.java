package com.marcelo_neuro.telusko_ecommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponseDTO {

    private String productName;
    private Integer quantity;
    private BigDecimal subTotal;
}
