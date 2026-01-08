package com.marcelo_neuro.telusko_ecommerce.controllers;

import com.marcelo_neuro.telusko_ecommerce.dtos.ProductRequestDTO;
import com.marcelo_neuro.telusko_ecommerce.dtos.ProductResponseDTO;
import com.marcelo_neuro.telusko_ecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findImageById(id));
    }

    @PostMapping(path = "/product")
    public ResponseEntity<?> add(@Valid @RequestPart ProductRequestDTO requestProduct,
                                                  @RequestPart MultipartFile imageFile) throws IOException {
        try {
            return ResponseEntity.ok(service.add(requestProduct, imageFile));
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
