package dev.scastillo.product.adapter.web.mapper;

import dev.scastillo.product.adapter.web.dto.ProductDto;
import dev.scastillo.product.adapter.web.dto.ProductRequestDto;
import dev.scastillo.product.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "categoryId", target = "category.id")
    Product toDomain(ProductRequestDto dto);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.title", target = "categoryTitle")
    @Mapping(source = "stock", target = "stock")
    ProductDto toDto(Product product);
}
