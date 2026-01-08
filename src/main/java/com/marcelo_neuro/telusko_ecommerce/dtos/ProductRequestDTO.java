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
public class ProductRequestDTO {

    private Long id;

    @NotBlank(message = "Field 'name' must be filled.")
    @Size(min = 3, max = 50, message = "Field 'name' must contain between 3 and 50 characters.")
    private String name;

    @NotBlank(message = "Field 'description' must be filled.")
    @Size(min = 3, max = 120, message = "Field 'description' must contain between 3 and 120 characters.")
    private String description;

    @NotBlank(message = "Field 'brand' must be filled.")
    @Size(min = 3, max = 50, message = "Field 'brand' must contain between 3 and 50 characters.")
    private String brand;

    @NotBlank(message = "Field 'category' must be filled.")
    @Size(min = 3, max = 50, message = "Field 'category' must contain between 3 and 50 characters.")
    private String category;

    @NotNull(message = "Field 'price' must be filled.")
    @Positive(message = "Field 'price', must be a positive value.")
    private BigDecimal price;

    @NotNull(message = "Field 'releaseDate' must be filled.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date releaseDate;
    private boolean productAvailable;

    @NotNull(message = "Field 'stockQuantity' must be filled.")
    @Positive(message = "Field 'stockQuantity', must be a positive value.")
    private Integer stockQuantity;

    public ProductRequestDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.brand = entity.getBrand();
        this.category = entity.getCategory();
        this.price = entity.getPrice();
        this.releaseDate = entity.getReleaseDate();
        this.productAvailable = entity.isProductAvailable();
        this.stockQuantity = entity.getStockQuantity();
    }
}
