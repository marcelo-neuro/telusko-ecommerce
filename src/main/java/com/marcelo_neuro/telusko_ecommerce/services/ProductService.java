package com.marcelo_neuro.telusko_ecommerce.services;

import com.marcelo_neuro.telusko_ecommerce.dtos.ProductDTO;
import com.marcelo_neuro.telusko_ecommerce.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductDTO> findAll() {
        return repository.findAll()
                .stream().map(ProductDTO::new)
                .toList();
    }

    public ProductDTO findById(Long id) {
        return new ProductDTO(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found. Id: " + id)));
    }
}
