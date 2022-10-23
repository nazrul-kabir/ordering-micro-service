package com.github.nazrulkabir.orderservice.bootstrap;

import com.github.nazrulkabir.orderservice.entity.Order;
import com.github.nazrulkabir.orderservice.entity.OrderState;
import com.github.nazrulkabir.orderservice.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrderLoader implements CommandLineRunner {
    public final OrderRepository orderRepository;

    public OrderLoader(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public void run(String... args) throws Exception {
        loadOrders();
    }

    private void loadOrders(){
        if(orderRepository.count() == 0){
            orderRepository.save(
                    Order.builder()
                            .productId(1L)
                            .quantity(1)
                            .orderState(OrderState.RUNNING)
                            .build()
            );
            orderRepository.save(
                    Order.builder()
                            .productId(2L)
                            .quantity(3)
                            .orderState(OrderState.RUNNING)
                            .build()
            );
            System.out.println("Sample Orders Loaded");
        }
    }
}
