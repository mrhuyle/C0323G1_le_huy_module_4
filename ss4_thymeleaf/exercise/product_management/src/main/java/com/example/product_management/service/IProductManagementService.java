package com.example.product_management.service;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductManagementService {
    List<Product> displayAll();
    void create(Product product);
}
