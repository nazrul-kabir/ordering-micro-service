package com.github.nazrulkabir.productservice.service;


import com.github.nazrulkabir.productservice.entity.Product;
import com.github.nazrulkabir.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product insert(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, Product product) {
        Product productFromDb = productRepository.findById(id).get();
        productFromDb.setName(product.getName());
        productFromDb.setCurrentStock(product.getCurrentStock());
        productFromDb.setDescription(product.getDescription());
        productFromDb.setType(product.getType());
        productRepository.save(productFromDb);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
