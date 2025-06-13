package dev.scastillo.product.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_stock")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductStock {
    @Id
    @Column(name = "product_id")
    private Integer productId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;
}
