package com.marcelo_neuro.telusko_ecommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {

    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;

}
