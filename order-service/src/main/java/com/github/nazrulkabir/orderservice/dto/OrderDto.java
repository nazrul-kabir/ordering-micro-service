package com.github.nazrulkabir.orderservice.dto;

import com.github.nazrulkabir.orderservice.entity.OrderState;
import lombok.Builder;

@Builder
public class OrderDto {
    private Long id;
    private ProductDto product;
    private int quantity;
    private OrderState orderState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
