package com.example.product_management.service;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductManagementService {
    List<Product> displayAll();
    void create(Product product);
    Product getProductById(int id);
    void update(Product product);
    void delete(int id);
    List<Product> searchByName(String name);
}
