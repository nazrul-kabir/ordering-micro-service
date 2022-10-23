package com.github.nazrulkabir.orderservice.controller;

import com.github.nazrulkabir.orderservice.dto.OrderDto;
import com.github.nazrulkabir.orderservice.entity.Order;
import com.github.nazrulkabir.orderservice.service.OrderService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //The function receives a GET request, processes it and gives back a list of Orders as a response.
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getOrders();
        return ResponseEntity.ok(orders);
    }

    //The function receives a GET request with Path variable, gets the data, and gives back the data as a response.
    @GetMapping({"/{id}"})
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    //The function receives a POST request, processes it, creates a new Order and saves it to the database, and returns a resource link to the created todo.
    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) throws ValidationException {
        Order saveOrder = orderService.insert(order);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("order", "/api/v1/order/" + saveOrder.getId().toString());
        return new ResponseEntity<>(saveOrder, httpHeaders, HttpStatus.CREATED);
    }
}
