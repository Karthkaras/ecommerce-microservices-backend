package com.karthik.microservices.product_service.repository;

import com.karthik.microservices.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Long> {

    // Find by category
    List<Product> findByCategory(String category);

    // Find by name containing
    List<Product> findByNameContaining(String name);

    // Find by price less than
    List<Product> findByPriceLessThan(Double price);

    // Find by price between
    List<Product> findByPriceBetween(
            Double minPrice, Double maxPrice);

    // Find by stock greater than 0
    List<Product> findByStockGreaterThan(
            Integer stock);

    // Find by category and stock available
    List<Product> findByCategoryAndStockGreaterThan(
            String category, Integer stock);
}