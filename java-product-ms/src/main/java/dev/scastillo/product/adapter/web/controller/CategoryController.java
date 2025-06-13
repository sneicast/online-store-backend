package dev.scastillo.product.adapter.web.controller;

import dev.scastillo.product.adapter.web.dto.CategoryDto;
import dev.scastillo.product.domain.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories().stream()
                .map(category -> new CategoryDto(category.getId(), category.getTitle()))
                .toList();
    }
}
