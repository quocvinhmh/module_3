package com.example.quan_ly_san_pham.service;

import com.example.quan_ly_san_pham.mode.Product;

import java.util.List;

public interface IProductService {
List<Product> findAll();
void save(Product product);
void delete(int id);
Product findById(int id);
void update(int id, Product product);
List<Product> findByName(String name);
int generateID();
}
