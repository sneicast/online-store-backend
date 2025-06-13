package dev.scastillo.product.domain.repository;

import dev.scastillo.product.domain.model.ProductStock;

public interface ProductStockRepository {
    ProductStock save(ProductStock productStock);
    ProductStock updateStock(Integer productId, Integer quantity);
    int getStock(Integer productId);
}
