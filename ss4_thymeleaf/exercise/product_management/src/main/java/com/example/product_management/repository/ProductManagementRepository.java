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
        try {
            System.out.println(product);
            entityManager.persist(product);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Product getProductById(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Transactional
    @Override
    public void update(Product product) {
        Product oldProduct = entityManager.find(Product.class, product.getId());
        oldProduct.setName(product.getName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setManufacturer(product.getManufacturer());
        oldProduct.setPrice(product.getPrice());
        entityManager.merge(oldProduct);
    }

    @Transactional
    @Override
    public void delete(int id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> searchByName(String name) {
        TypedQuery<Product> query = entityManager.createQuery(" select p from Product p WHERE p.name LIKE :name", Product.class);
        query.setParameter("name", name);
        List<Product> products = query.getResultList();
        return products;
    }
}
