package dev.scastillo.product.infrastructure.repository;

import dev.scastillo.product.domain.model.Product;
import dev.scastillo.product.domain.model.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface SpringDataProductStockRepository extends JpaRepository<ProductStock, Integer> {

    Optional<ProductStock> findByProductId(Integer productId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE product_stock SET quantity = :quantity WHERE product_id = :productId", nativeQuery = true)
    int updateQuantityByProductId(Integer productId, Integer quantity);

}
