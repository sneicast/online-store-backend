package dev.scastillo.product.application.service;

import dev.scastillo.product.domain.model.Category;
import dev.scastillo.product.domain.model.Product;
import dev.scastillo.product.domain.model.ProductStock;
import dev.scastillo.product.domain.repository.CategoryRepository;
import dev.scastillo.product.domain.repository.ProductRepository;
import dev.scastillo.product.domain.repository.ProductStockRepository;
import dev.scastillo.product.domain.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductStockRepository productStockRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product createProduct(Product product, int stockQuantity) {

        if (product.getCategory() == null || product.getCategory().getId() == null) {
            throw new IllegalArgumentException("Product category must be set before creating a product.");
        }
        Category category = categoryRepository.getById(product.getCategory().getId());
        product.setCategory(category);
        Product productResult = productRepository.save(product);
        ProductStock productStock = ProductStock.builder()
                .product(productResult)
                .quantity(stockQuantity)
                .build();
        productStockRepository.save(productStock);

        Optional<Product> result = productRepository.findById(productResult.getId());
        if (result.isEmpty()) {
            throw new IllegalArgumentException("Product not found after creation: " + productResult.getId());
        }
        return result.get();
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        Product resultProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));

        resultProduct.setName(product.getName());
        resultProduct.setDescription(product.getDescription());
        resultProduct.setPrice(product.getPrice());
        resultProduct.setImageUrl(product.getImageUrl());
        return productRepository.save(resultProduct);
    }

    @Override
    public Product getProductById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
        int stock = productStockRepository.getStock(product.getId());
        product.setStock(stock);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            int stock = productStockRepository.getStock(product.getId());
            product.setStock(stock);
        }
        return products;
    }

    @Override
    public void updateProductStock(int productId, int quantity) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + productId));
        productStockRepository.updateStock(productId, quantity);
    }
}
