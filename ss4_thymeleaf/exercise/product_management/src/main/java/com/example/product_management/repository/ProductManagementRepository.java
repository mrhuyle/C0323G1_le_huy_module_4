package com.example.product_management.repository;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductManagementRepository implements IProductManagementRepsitory {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1,"Iphone 14", 999.99, "A fantastic phone with great features.", "Apple"));
        productList.add(new Product(2,"ZFlip", 899.99, "An advanced phone with cutting-edge technology.", "Samsung"));
        productList.add(new Product(3,"Pixel", 799.99, "A budget-friendly phone with decent specifications.", "Google"));
        productList.add(new Product(4,"P60 Pro", 599.99, "A cheap phone with Vision Enlightened.", "Huawei"));
        productList.add(new Product(5,"XR21", 499.99, "A phone is made by strong materials and recycle aluminum", "Nokia"));
    }


    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product getProductById(int id) {
        for (Product product: productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        Product oldProduct = getProductById(product.getId());
        oldProduct.setName(product.getName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setManufacturer(product.getManufacturer());
        oldProduct.setPrice(product.getPrice());
    }

    @Override
    public void delete(int id) {
        Product product = getProductById(id);
        productList.remove(product);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Product product: productList) {
            if (product.getName().toLowerCase().contains(name)) {
                products.add(product);
            }
        }
        return products;
    }
}
