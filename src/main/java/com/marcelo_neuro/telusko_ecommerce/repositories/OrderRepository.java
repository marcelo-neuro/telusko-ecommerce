package com.marcelo_neuro.telusko_ecommerce.repositories;

import com.marcelo_neuro.telusko_ecommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findOrderByOrderCode(String orderCode);
}
