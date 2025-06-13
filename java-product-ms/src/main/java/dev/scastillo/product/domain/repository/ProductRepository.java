package dev.scastillo.product.domain.repository;

import dev.scastillo.product.domain.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    List<Product> findAll();
    Product save(Product product);
    Optional<Product> findById(Integer id);

}
