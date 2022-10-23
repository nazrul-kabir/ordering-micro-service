package com.github.nazrulkabir.orderservice.utils;

import com.github.nazrulkabir.orderservice.dto.OrderDto;
import com.github.nazrulkabir.orderservice.dto.ProductDto;
import com.github.nazrulkabir.orderservice.entity.Order;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    private static OrderMapper orderMapperInstance;

    public static OrderMapper getInstance() {
        if (ObjectUtils.isEmpty(orderMapperInstance)) {
            orderMapperInstance = new OrderMapper();
        }
        return orderMapperInstance;
    }
    public List<OrderDto> mapProductWithOrder(List<Order> orders, List<ProductDto> products){
        List<OrderDto> orderDtoList = new ArrayList<>();
        orders.forEach(order -> {
            ProductDto productData = products.stream()
                    .filter(product -> order.getProductId() ==(product.getId()))
                    .findAny()
                    .orElse(null);
            var orderDto = OrderDto.builder()
                    .id(order.getId())
                    .product(productData)
                    .quantity(order.getQuantity())
                    .orderState(order.getOrderState())
                    .build();
            orderDtoList.add(orderDto);
        });
        return orderDtoList;
    }
}
