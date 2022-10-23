package com.github.nazrulkabir.productservice.bootstrap;

import com.github.nazrulkabir.productservice.entity.Product;
import com.github.nazrulkabir.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductLoader implements CommandLineRunner {
    public final ProductRepository productRepository;

    public ProductLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadProducts();
    }

    private void loadProducts() {
        if (productRepository.count() == 0) {
            productRepository.save(
                    Product.builder()
                            .name("Dell Precision 5550")
                            .currentStock(99)
                            .description("The world's smallest and thinnest 15 inch mobile workstation.")
                            .type("Laptop")
                            .build()
            );
            productRepository.save(
                    Product.builder()
                            .name("Dell Precision 5570")
                            .currentStock(5)
                            .description("The world's thinnest 15 inch mobile workstation.")
                            .type("Laptop")
                            .build()
            );
            System.out.println("Sample Products Loaded");
        }
    }
}
