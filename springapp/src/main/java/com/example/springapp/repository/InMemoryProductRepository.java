// InMemoryProductRepository.java
package com.example.springapp.repository;

import com.example.springapp.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private final Map<Long, Product> products = new HashMap<>();
    private long idCounter = 1L;

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(idCounter++);
        }
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }
}
