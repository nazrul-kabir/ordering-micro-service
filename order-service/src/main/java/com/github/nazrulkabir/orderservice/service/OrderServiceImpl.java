package com.github.nazrulkabir.orderservice.service;

import com.github.nazrulkabir.orderservice.dto.OrderDto;
import com.github.nazrulkabir.orderservice.dto.ProductDto;
import com.github.nazrulkabir.orderservice.entity.Order;
import com.github.nazrulkabir.orderservice.repository.OrderRepository;
import com.github.nazrulkabir.orderservice.utils.OrderMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    OrderRepository orderRepository;
    private final OrderMapper orderMapper = OrderMapper.getInstance();

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<OrderDto> getOrders() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        ProductDto[] products = getProducts();
        return orderMapper.mapProductWithOrder(orders, List.of(products));
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Order insert(Order order) throws ValidationException {
        validateOrder(order);
        return orderRepository.save(order);
    }

    @Override
    public void updateOrder(Long id, Order order) {

    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public void validateOrder(Order order) throws ValidationException {
        //Check productId is valid via REST API
        ProductDto productFromAPI = (ProductDto) getProduct(order.getProductId());
        if (productFromAPI == null) {
            throw new ValidationException("Product doesn't exists");
        }
        //Check stock of the product
        if(order.getQuantity() > productFromAPI.getCurrentStock()){
            throw new ValidationException("Not enough stock");
        }
    }

    //Later move these functions to separate file
    private static Object getProduct(long id)
    {
        final String uri = "http://localhost:3001/api/v1/product/"+id;
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ProductDto> response =
                restTemplate.getForEntity(
                        uri,
                        ProductDto.class);
        ProductDto product = response.getBody();
        return product;
    }
    private static ProductDto[] getProducts()
    {
        final String uri = "http://localhost:3001/api/v1/product/";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProductDto[]> response =
                restTemplate.getForEntity(
                        uri,
                        ProductDto[].class);
        ProductDto[] products = response.getBody();
        return products;
    }
}
