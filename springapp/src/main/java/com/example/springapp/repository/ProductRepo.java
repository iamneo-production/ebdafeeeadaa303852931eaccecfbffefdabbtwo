package com.example.springapp.repository;

import com.example.springapp.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepo {

    Optional<Product> findById(Long id);

    Product save(Product product);

    List<Product> findAll();
}
