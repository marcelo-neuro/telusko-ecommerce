package com.marcelo_neuro.telusko_ecommerce.services;

import com.marcelo_neuro.telusko_ecommerce.dtos.ProductRequestDTO;
import com.marcelo_neuro.telusko_ecommerce.dtos.ProductResponseDTO;
import com.marcelo_neuro.telusko_ecommerce.entities.Product;
import com.marcelo_neuro.telusko_ecommerce.entities.ProductImage;
import com.marcelo_neuro.telusko_ecommerce.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductResponseDTO> findAll() {
        return repository.findAll()
                .stream().map(ProductResponseDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public ProductResponseDTO findById(Long id) {
        Product p = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found. Id: " + id));

        return new ProductResponseDTO(p);
    }

    @Transactional(readOnly = true)
    public byte[] findImageById(Long id) {
        return findById(id).getImageData();
    }

    @Transactional(readOnly = true)
    public List<ProductResponseDTO> search(String keyword) {
        return repository.searchByKeyword(keyword)
                .stream().map(ProductResponseDTO::new)
                .toList();
    }

    @Transactional
    public ProductResponseDTO add(ProductRequestDTO productDTO, MultipartFile image) throws IOException {
        Product entity = new Product();
        dtoToEntity(productDTO, entity);

        entity.setImage(new ProductImage());
        entity.getImage().setImageName(image.getName());
        entity.getImage().setImageType(image.getContentType());
        entity.getImage().setImageData(image.getBytes());

        return new ProductResponseDTO(repository.save(entity));
    }

    @Transactional
    public ProductResponseDTO update(Long id, ProductRequestDTO productRequestDTO, MultipartFile imageFile) throws IOException {
        Product entity = repository.getReferenceById(id);

        dtoToEntity(productRequestDTO, entity);

        entity.getImage().setImageName(imageFile.getName());
        entity.getImage().setImageType(imageFile.getContentType());
        entity.getImage().setImageData(imageFile.getBytes());

        return new ProductResponseDTO(repository.save(entity));
    }

    @Transactional
    public void delete(Long id) {
        if(!repository.existsById(id)) {
            throw new EntityNotFoundException("Product not found. Id: " + id);
        }

        repository.deleteById(id);
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
