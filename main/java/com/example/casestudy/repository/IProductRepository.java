package com.example.casestudy.repository;

import com.example.casestudy.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    boolean add(Product product);
    Product findById(int id);
    boolean update(Product product);
    boolean delete(int product);
    List<Product> findByName(String name);
}
