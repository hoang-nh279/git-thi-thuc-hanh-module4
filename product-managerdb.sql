create database product_managerdb;
use product_managerdb;

CREATE TABLE categories (
  cid BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE products (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  price DOUBLE NOT NULL,
  status VARCHAR(50) NOT NULL,
  id_loai_sp BIGINT,
  FOREIGN KEY (id_loai_sp) REFERENCES categories(cid)
);
INSERT INTO categories (name) VALUES 
('Tivi'),
('Tủ lạnh'),
('Máy giặt'),
('Lò vi sóng');


