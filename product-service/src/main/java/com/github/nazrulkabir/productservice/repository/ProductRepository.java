package com.github.nazrulkabir.productservice.repository;

import com.github.nazrulkabir.productservice.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
