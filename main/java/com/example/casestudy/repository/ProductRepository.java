package com.example.casestudy.repository;

import com.example.casestudy.model.Product;
import com.example.casestudy.utli.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final String SELECT_ALL = "select * from product";
    private final String DELETE_BY_ID = "delete from product where id = ?";
    private final String UPDATE_BY_ID = "update product set name = ?, price = ?, description = ?, manufacturer = ? where id = ?";
    private final String INSERT_PRODUCT = "insert into product(name, price,description,manufacturer) values(?,?,?,?)";
    private final String FIND_BY_NAME = "select * from product where name LIKE ?";
    Connection conn = BaseRepository.getConnection();

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String manufacturer = resultSet.getString("manufacturer");
                Product product = new Product(id, name, price, description, manufacturer);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public boolean add(Product product) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getManufacturer());
            int executeUpdate = preparedStatement.executeUpdate();
            return executeUpdate == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Product findById(int id) {
        List<Product> products = new ArrayList<>();
        String FIND_BY_ID = "select * from product where id = ?";
        try (Connection conn = BaseRepository.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String manufacturer = resultSet.getString("manufacturer");
                Product product = new Product(productId, name, price, description, manufacturer);
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products.get(0);
    }

    @Override
    public boolean update(Product product) {
        try (Connection conn = BaseRepository.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_BY_ID)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getManufacturer());
            preparedStatement.setInt(5, product.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("lỗi cập nhật");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int product) {
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setInt(1, product);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("lỗi xóa sản phẩm");
            return false;
        }
        return true;

    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> searchList = new ArrayList<>();
        try (Connection conn = BaseRepository.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(FIND_BY_NAME)) {

            preparedStatement.setString(1, "%" + name + "%"); // Tìm kiếm gần đúng (LIKE)
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productName = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String manufacturer = resultSet.getString("manufacturer");

                Product product = new Product(id, productName, price, description, manufacturer);
                searchList.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi tìm kiếm sản phẩm: " + e.getMessage());
        }
        return searchList;
    }
}
