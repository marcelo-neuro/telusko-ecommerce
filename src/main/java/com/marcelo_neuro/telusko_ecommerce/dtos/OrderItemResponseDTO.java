package com.marcelo_neuro.telusko_ecommerce.dtos;

import com.marcelo_neuro.telusko_ecommerce.entities.OrderItem;
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

    public OrderItemResponseDTO(OrderItem entity) {
        this.productName = entity.getProduct().getName();
        this.quantity = entity.getQuantity();
        this.subTotal = entity.getProduct().getPrice()
                .multiply(BigDecimal.valueOf(quantity));
    }
}
