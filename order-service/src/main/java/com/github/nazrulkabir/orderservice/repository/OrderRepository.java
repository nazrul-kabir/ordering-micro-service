package com.github.nazrulkabir.orderservice.repository;

import com.github.nazrulkabir.orderservice.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
