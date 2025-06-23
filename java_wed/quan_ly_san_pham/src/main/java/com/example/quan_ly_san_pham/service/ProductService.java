package com.example.quan_ly_san_pham.service;

import com.example.quan_ly_san_pham.mode.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private static List<Product> products = new ArrayList<Product>();
    static {
        products.add(new Product(1, "Laptop", 1500, "Laptop Gaming", "Razer"));
        products.add(new Product(2, "Smartphone", 800, "Điện thoại", "Apple"));
        products.add(new Product(3, "Tablet", 400, "Máy tính bảng", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void delete(int id) {
for (Product product : products) {
    if (product.getId() == id) {
        products.remove(product);
    }
}
    }

    @Override
    public Product findById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(int id, Product product) {
for (Product product1 : products) {
    if (product.getId() == id){
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setManufacturer(product.getManufacturer());
        return;
    }
}
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public int generateID() {
        int id = 0;
        for (Product product : products) {
            if (product.getId() > id) {
                id = product.getId();
            }
        }
        return id + 1;
    }
}
