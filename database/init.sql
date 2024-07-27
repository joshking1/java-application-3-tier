CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

INSERT INTO users (username, password) VALUES ('admin', 'admin');
