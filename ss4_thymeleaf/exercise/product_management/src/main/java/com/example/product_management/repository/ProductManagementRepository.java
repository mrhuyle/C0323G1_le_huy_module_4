package com.example.product_management.repository;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductManagementRepository implements IProductManagementRepsitory {
    @PersistenceContext
    private EntityManager entityManager;


    private static List<Product> productList = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        TypedQuery<Product> query = entityManager.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public boolean save(Product product) {
//        try {
//            System.out.println(product);
            entityManager.persist(product);
//        } catch (Exception e) {
//            return false;
//        }
        return true;
    }

    @Override
    public Product getProductById(int id) {
        for (Product product : productList) {
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
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(name)) {
                products.add(product);
            }
        }
        return products;
    }
}
