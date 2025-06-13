package dev.scastillo.product.domain.repository;

import dev.scastillo.product.domain.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
    Category getById(Integer id);
}
