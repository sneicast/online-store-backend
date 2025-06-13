package dev.scastillo.product.infrastructure.repository;

import dev.scastillo.product.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataProductRepository extends JpaRepository<Product, Integer> {
}
