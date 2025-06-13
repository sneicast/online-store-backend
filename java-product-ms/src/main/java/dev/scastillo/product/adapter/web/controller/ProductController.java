package dev.scastillo.product.adapter.web.controller;

import dev.scastillo.product.adapter.web.dto.ProductDto;
import dev.scastillo.product.adapter.web.dto.ProductRequestDto;
import dev.scastillo.product.adapter.web.dto.ProductStockRequestDto;
import dev.scastillo.product.adapter.web.mapper.ProductMapper;
import dev.scastillo.product.domain.model.Product;
import dev.scastillo.product.domain.model.ProductStock;
import dev.scastillo.product.domain.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper  productMapper;

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductRequestDto request) {
        Product result = productService.createProduct(productMapper.toDomain(request), request.getStockQuantity());
        return  productMapper.toDto(result);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Integer id, @RequestBody ProductRequestDto request) {
        Product product = productMapper.toDomain(request);
        Product result = productService.updateProduct(id, product);
        return productMapper.toDto(result);
    }
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Integer id) {
        Product result = productService.getProductById(id);
        return productMapper.toDto(result);
    }
    @GetMapping
    public Iterable<ProductDto> getAllProducts() {
        return productService.getAllProducts().stream()
                .map(productMapper::toDto)
                .toList();
    }
    @PutMapping("/{id}/stock")
    public void updateProductStock(@PathVariable Integer id, @RequestBody ProductStockRequestDto request) {
        productService.updateProductStock(id, request.getStockQuantity());
    }
}
