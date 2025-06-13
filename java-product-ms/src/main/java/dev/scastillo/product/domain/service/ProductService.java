package dev.scastillo.product.domain.service;

import dev.scastillo.product.domain.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product, int stockQuantity);
    Product updateProduct(Integer id, Product product);
    Product getProductById(Integer id);
    List<Product> getAllProducts();
    void updateProductStock(int productId, int quantity);
}
