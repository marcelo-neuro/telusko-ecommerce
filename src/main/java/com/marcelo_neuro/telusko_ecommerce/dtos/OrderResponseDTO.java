package com.marcelo_neuro.telusko_ecommerce.dtos;

import com.marcelo_neuro.telusko_ecommerce.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {

    private String orderCode;
    private String customerName;
    private String customerEmail;
    private String status;
    private LocalDate orderDate;
    private List<OrderItemResponseDTO> items;

    public OrderResponseDTO(Order entity) {
        this.orderCode = entity.getOrderCode();
        this.customerName = entity.getCustomerName();
        this.customerEmail = entity.getCustomerEmail();
        this.status = entity.getStatus();
        this.orderDate = entity.getOrderDate();

        this.items = entity.getOrderItems()
                .stream().map(OrderItemResponseDTO::new)
                .toList();
    }
}
