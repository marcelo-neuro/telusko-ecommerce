package com.marcelo_neuro.telusko_ecommerce.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcelo_neuro.telusko_ecommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String description;
    private String brand;
    private String category;
    private BigDecimal price;
    private Date releaseDate;
    private boolean productAvailable;
    private Integer stockQuantity;

    private String imageName;
    private String imageType;
    private byte[] imageData;

    public ProductResponseDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.brand = entity.getBrand();
        this.category = entity.getCategory();
        this.price = entity.getPrice();
        this.releaseDate = entity.getReleaseDate();
        this.productAvailable = entity.isProductAvailable();
        this.stockQuantity = entity.getStockQuantity();

        this.imageName = entity.getImage().getImageName();
        this.imageType = entity.getImage().getImageType();
        this.imageData = entity.getImage().getImageData();
    }


}
