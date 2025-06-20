package dev.scastillo.product.infrastructure.repository;

import dev.scastillo.product.domain.model.Product;
import dev.scastillo.product.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@AllArgsConstructor
@Repository
public class JpaProductRepository implements ProductRepository {
    private final SpringDataProductRepository repository;
    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return repository.findById(id);
    }
}
