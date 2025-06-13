package dev.scastillo.product.adapter.web.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Integer id;

    private String name;

    private String description;

    private BigDecimal price;

    private String imageUrl;

    private int categoryId;

    private String categoryTitle;

    private Boolean status;

    private Integer stock;
}
