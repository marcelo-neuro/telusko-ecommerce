package com.marcelo_neuro.telusko_ecommerce.services;

import com.marcelo_neuro.telusko_ecommerce.dtos.ProductRequestDTO;
import com.marcelo_neuro.telusko_ecommerce.dtos.ProductResponseDTO;
import com.marcelo_neuro.telusko_ecommerce.entities.Product;
import com.marcelo_neuro.telusko_ecommerce.entities.ProductImage;
import com.marcelo_neuro.telusko_ecommerce.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductResponseDTO> findAll() {
        return repository.findAll()
                .stream().map(ProductResponseDTO::new)
                .toList();
    }

    public ProductResponseDTO findById(Long id) {
        Product p = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found. Id: " + id));

        return new ProductResponseDTO(p);
    }

    public byte[] findImageById(Long id) {
        byte[] image = findById(id).getImageData();
        return image;
    }

    public ProductResponseDTO add(ProductRequestDTO productDTO, MultipartFile image) throws IOException {
        Product entity = new Product();
        dtoToEntity(productDTO, entity);

        entity.setImage(new ProductImage());
        entity.getImage().setImageName(image.getName());
        entity.getImage().setImageType(image.getContentType());
        entity.getImage().setImageData(image.getBytes());

        return new ProductResponseDTO(repository.save(entity));
    }

    private void dtoToEntity(ProductRequestDTO productDTO, Product entity) {
        entity.setName(productDTO.getName());
        entity.setDescription(entity.getDescription());
        entity.setBrand(productDTO.getBrand());
        entity.setCategory(productDTO.getCategory());
        entity.setPrice(productDTO.getPrice());
        entity.setReleaseDate(productDTO.getReleaseDate());
        entity.setProductAvailable(productDTO.isProductAvailable());
        entity.setStockQuantity(productDTO.getStockQuantity());


    }
}
