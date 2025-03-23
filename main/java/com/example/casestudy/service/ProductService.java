package com.example.casestudy.service;

import com.example.casestudy.model.Product;
import com.example.casestudy.repository.IProductRepository;

import java.util.List;

public class ProductService implements IProductService {
IProductRepository productService = new IProductRepository() {
    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public boolean add(Product product) {
        return false;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public boolean delete(int product) {
        return false;
    }

    @Override
    public List<Product> findByName(String name) {
        return productService.findByName(name);
    }
};
    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public boolean add(Product product) {
        productService.add(product);
        return false;
    }

    @Override
    public Product findById(int id) {
        return productService.findById(id);
    }

    @Override
    public void update(Product product) {
productService.update(product);
    }

    @Override
    public boolean delete(int product) {
productService.delete(product);
        return false;
    }

    @Override
    public List<Product> findByName(String name) {
        return productService.findByName(name);
    }
}
