package dev.scastillo.product.infrastructure.repository;

import dev.scastillo.product.domain.model.Category;
import dev.scastillo.product.domain.repository.CategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCategoryRepository extends JpaRepository<Category, Integer> {
}
