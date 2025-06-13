package dev.scastillo.product.infrastructure.repository;

import dev.scastillo.product.domain.model.Category;
import dev.scastillo.product.domain.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@AllArgsConstructor
@Repository
public class JpaCategoryRepository implements CategoryRepository {
    private final SpringDataCategoryRepository repository;
    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + id));
    }
}
