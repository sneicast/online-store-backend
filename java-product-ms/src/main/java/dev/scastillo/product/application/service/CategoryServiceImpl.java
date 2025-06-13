package dev.scastillo.product.application.service;

import dev.scastillo.product.domain.model.Category;
import dev.scastillo.product.domain.repository.CategoryRepository;
import dev.scastillo.product.domain.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements  CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
