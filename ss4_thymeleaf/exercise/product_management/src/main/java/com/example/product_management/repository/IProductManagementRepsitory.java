package com.example.product_management.repository;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductManagementRepsitory {
    List<Product> getAllProducts();
    void save(Product product);
    Product getProductById(int id);
    void update(Product product);
    void delete(int id);
    List<Product> searchByName(String name);
}
