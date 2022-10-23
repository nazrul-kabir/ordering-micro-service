package com.github.nazrulkabir.productservice.controller;

import com.github.nazrulkabir.productservice.entity.Product;
import com.github.nazrulkabir.productservice.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //The function receives a GET request, processes it and gives back a list of Products as a response.
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //The function receives a GET request with Path variable, gets the data, and gives back the data as a response.
    @GetMapping({"/{id}"})
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    //The function receives a POST request, processes it, creates a new Product and saves it to the database, and returns a resource link to the created todo.
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product saveProduct = productService.insert(product);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("product", "/api/v1/product/" + saveProduct.getId().toString());
        return new ResponseEntity<>(saveProduct, httpHeaders, HttpStatus.CREATED);
    }

    //The function receives a POST request, updates the existing Products to the database, and returns a resource link to the created todo.
    @PostMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    //The function receives a DELETE request, deletes the Product with the specified Id.
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
