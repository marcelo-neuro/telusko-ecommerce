package com.marcelo_neuro.telusko_ecommerce.repositories;

import com.marcelo_neuro.telusko_ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
