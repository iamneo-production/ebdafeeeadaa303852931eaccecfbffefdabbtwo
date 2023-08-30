package com.example.springapp.service;

import com.example.springapp.exception.InvalidProductException;
import com.example.springapp.exception.ProductNotFoundException;
import com.example.springapp.model.Product;
import com.example.springapp.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with the provided ID does not exist."));
    }

    public Product createProduct(Product product) {
        validateProduct(product);

        return productRepo.save(product);
    }    

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    private void validateProduct(Product product) {
        if (product.getName() == null || product.getDescription() == null || product.getPrice() <= 0 || product.getQuantity() < 0) {
            throw new InvalidProductException("Invalid product details. Please provide valid values for all fields.");
        }
    }
}
