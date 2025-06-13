package dev.scastillo.product.adapter.web.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDto {

    private String name;

    private String description;

    private BigDecimal price;

    private String imageUrl;

    private int categoryId;

    private Boolean status;

    private int stockQuantity;
}
