package com.example.casestudy.service;

import com.example.casestudy.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    boolean add(Product product);
    Product findById(int id);
    void update(Product product);
    boolean delete(int product);
    List<Product> findByName(String name);
}
