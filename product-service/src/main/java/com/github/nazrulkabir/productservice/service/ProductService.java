package com.github.nazrulkabir.productservice.service;

import com.github.nazrulkabir.productservice.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product getProductById(Long id);

    Product insert(Product product);

    void updateProduct(Long id, Product product);

    void deleteProduct(Long productId);
}