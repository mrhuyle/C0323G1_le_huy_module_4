package com.example.product_management.service;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IProductManagementRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManagementService implements IProductManagementService {
    @Autowired
    private IProductManagementRepsitory productManagementRepsitory;

    @Override
    public List<Product> displayAll() {
        return productManagementRepsitory.getAllProducts();
    }

    @Override
    public void create(Product product) {
        productManagementRepsitory.save(product);
    }

    @Override
    public Product getProductById(int id) {
        return productManagementRepsitory.getProductById(id);
    }

    @Override
    public void update(Product product) {
        productManagementRepsitory.update(product);
    }

    @Override
    public void delete(int id) {
        productManagementRepsitory.delete(id);
    }
}
