package dev.scastillo.product.infrastructure.repository;

import dev.scastillo.product.domain.model.ProductStock;
import dev.scastillo.product.domain.repository.ProductStockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class JpaProductStockRepository implements ProductStockRepository {
    private final SpringDataProductStockRepository repository;

    @Override
    public ProductStock save(ProductStock productStock) {
        return repository.save(productStock);
    }

    @Override
    public ProductStock updateStock(Integer productId, Integer quantity) {
        repository.updateQuantityByProductId(productId, quantity);
        return repository.findByProductId(productId).orElse(null);
    }

    @Override
    public int getStock(Integer productId) {
        var productStock = repository.findByProductId(productId);
        if (productStock.isEmpty()) {
            return 0; // or throw an exception if preferred
        }
        return productStock.get().getQuantity();

    }
}
