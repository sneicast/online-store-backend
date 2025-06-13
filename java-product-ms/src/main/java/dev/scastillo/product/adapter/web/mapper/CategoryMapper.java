package dev.scastillo.product.adapter.web.mapper;

import dev.scastillo.product.adapter.web.dto.CategoryDto;
import dev.scastillo.product.domain.model.Category;

public interface CategoryMapper {
    Category toDomain(CategoryDto dto);
    CategoryDto toDto(Category category);

}
