package dev.scastillo.product.adapter.web.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductStockRequestDto {
    private int stockQuantity;
}
