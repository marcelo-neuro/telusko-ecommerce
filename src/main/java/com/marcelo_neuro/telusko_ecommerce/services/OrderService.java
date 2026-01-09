package com.marcelo_neuro.telusko_ecommerce.services;

import com.marcelo_neuro.telusko_ecommerce.dtos.OrderItemRequestDTO;
import com.marcelo_neuro.telusko_ecommerce.dtos.OrderRequestDTO;
import com.marcelo_neuro.telusko_ecommerce.dtos.OrderResponseDTO;
import com.marcelo_neuro.telusko_ecommerce.entities.Order;
import com.marcelo_neuro.telusko_ecommerce.entities.OrderItem;
import com.marcelo_neuro.telusko_ecommerce.entities.Product;
import com.marcelo_neuro.telusko_ecommerce.repositories.OrderRepository;
import com.marcelo_neuro.telusko_ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public OrderResponseDTO add(OrderRequestDTO request) {
        String uuid = "ORD" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        List<OrderItem> item = new ArrayList<>();

        Order order = Order.builder()
                .orderCode(uuid)
                .customerName(request.getCustomerName())
                .customerEmail(request.getCustomerEmail())
                .orderDate(LocalDate.now())
                .status("PLACED")
                .orderItems(item)
                .build();

        for(OrderItemRequestDTO orderDto : request.getItem()) {
            Product product = productRepository.getReferenceById(orderDto.getProductId());

            if(orderDto.getQuantity() > product.getStockQuantity()) {
                throw new RuntimeException("Order quantity is greater than product stock quantity.");
            }

            item.add(OrderItem.builder()
                    .product(product)
                    .quantity(orderDto.getQuantity())
                    .order(order)
                    .build());

        }

        order = orderRepository.save(order);
        return new OrderResponseDTO(order);
    }

    @Transactional(readOnly = true)
    public List<OrderResponseDTO> findAll() {
        return orderRepository.findAll()
                .stream().map(OrderResponseDTO::new)
                .toList();
    }
}
