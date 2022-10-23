package com.github.nazrulkabir.orderservice.service;

import com.github.nazrulkabir.orderservice.dto.OrderDto;
import com.github.nazrulkabir.orderservice.entity.Order;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface OrderService {
    List<OrderDto> getOrders();

    Order getOrderById(Long id);

    Order insert(Order order) throws ValidationException;

    void updateOrder(Long id, Order order);

    void deleteOrder(Long orderId);
}
