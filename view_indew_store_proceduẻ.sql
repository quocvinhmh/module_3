create database if not exists ss5_view_index_store_procedure;
use ss5_view_index_store_procedure;
-- tạo bảng Products---
create table products(
                         id int primary key auto_increment,
                         product_code varchar(50),
                         product_name varchar(50),
                         product_price int,
                         product_amount int ,
                         product_description varchar(50),
                         product_status enum('Còn hàng','Hết hàng') not null
);
-- thêm dữ liệu --
insert into products (product_code, product_name, product_price, product_amount, product_description, product_status)
values
    ('P001', 'Laptop Dell', 1500, 10, 'High-performance laptop', 'Còn hàng'),
    ('P002', 'iPhone 15', 1200, 5, 'Latest Apple smartphone', 'Còn hàng'),
    ('P003', 'Samsung Galaxy S24', 1100, 8, 'Newest Samsung flagship phone', 'Còn hàng'),
    ('P004', 'MacBook Pro M3', 2000, 6, 'Apple MacBook Pro with M3 chip', 'Còn hàng'),
    ('P005', 'Sony WH-1000XM5', 350, 15, 'Noise-canceling wireless headphones', 'Còn hàng'),
    ('P006', 'iPad Air 2024', 700, 12, 'Lightweight and powerful tablet', 'Còn hàng'),
    ('P007', 'Logitech MX Master 3', 100, 20, 'High-precision wireless mouse', 'Còn hàng');
-- câu 3 --
explain select * from products where product_name = 'Laptop Dell' and product_price = 1500;

create unique index idx_product_code ON products (product_code);

create unique index idx_product_productName_productPrice on products (product_name,product_price);

EXPLAIN select * from products where product_name = 'Laptop Dell' and product_price = 1500;

create view products_view as select product_code, product_name, product_price, product_amount, product_status
from products;

drop view if exists product_view;
-- câu 4 --
DELIMITER //

CREATE PROCEDURE get_all_products()
BEGIN
    SELECT * FROM products;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE addProduct(
    IN p_product_code VARCHAR(50),
    IN p_product_name VARCHAR(50),
    IN p_product_price INT,
    IN p_product_amount INT,
    IN p_product_description VARCHAR(50),
    IN p_product_status ENUM('Còn hàng', 'Hết hàng')
)
BEGIN
    INSERT INTO products (product_code, product_name, product_price, product_amount, product_description, product_status)
    VALUES (p_product_code, p_product_name, p_product_price, p_product_amount, p_product_description, p_product_status);
END //

DELIMITER ;
-- câu 5 --
DELIMITER //

CREATE PROCEDURE update_product(
    IN p_id INT,
    IN p_product_code VARCHAR(50),
    IN p_product_name VARCHAR(50),
    IN p_product_price INT,
    IN p_product_amount INT,
    IN p_product_description VARCHAR(50),
    IN p_product_status ENUM('Còn hàng', 'Hết hàng')
)
BEGIN
    UPDATE products
    SET product_code = p_product_code,
        product_name = p_product_name,
        product_price = p_product_price,
        product_amount = p_product_amount,
        product_description = p_product_description,
        product_status = p_product_status
    WHERE id = p_id;
END //

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE delete_product(IN p_id INT)
BEGIN
    DELETE FROM products WHERE id = p_id;
END $$

DELIMITER ;