package com.karthik.microservices.product_service.service;

import com.karthik.microservices.product_service.model.Product;
import com.karthik.microservices.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository
            productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Product not found: " + id));
    }

    public List<Product> getByCategory(
            String category) {
        return productRepository
                .findByCategory(category);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(
            Long id, Product updated) {
        Product existing = getById(id);
        existing.setName(updated.getName());
        existing.setPrice(updated.getPrice());
        existing.setStock(updated.getStock());
        existing.setDescription(
                updated.getDescription());
        return productRepository.save(existing);
    }

    // Called by Order Service
    // to reduce stock
    public Product reduceStock(
            Long id, Integer quantity) {
        Product product = getById(id);
        if (product.getStock() < quantity) {
            throw new RuntimeException(
                    "Insufficient stock!");
        }
        product.setStock(
                product.getStock() - quantity);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}