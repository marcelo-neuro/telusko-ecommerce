package com.marcelo_neuro.telusko_ecommerce.controllers;

import com.marcelo_neuro.telusko_ecommerce.dtos.ProductDTO;
import com.marcelo_neuro.telusko_ecommerce.entities.Product;
import com.marcelo_neuro.telusko_ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
