package com.karthik.microservices.product_service.controller;

import com.karthik.microservices.product_service.model.Product;
import com.karthik.microservices.product_service.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(
                productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                productService.getById(id));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>>
    getByCategory(
            @PathVariable String category) {
        return ResponseEntity.ok(
                productService.getByCategory(category));
    }

    @PostMapping
    public ResponseEntity<Product> create(
            @RequestBody @Valid Product product) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService
                        .createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @PathVariable Long id,
            @RequestBody Product product) {
        return ResponseEntity.ok(
                productService.updateProduct(
                        id, product));
    }

    // Internal API for Order Service
    @PutMapping("/{id}/reduce-stock")
    public ResponseEntity<Product> reduceStock(
            @PathVariable Long id,
            @RequestParam Integer quantity) {
        return ResponseEntity.ok(
                productService.reduceStock(
                        id, quantity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Deleted!");
    }
}