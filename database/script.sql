create database bookstore;

use bookstore;

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL DEFAULT 'USER'
);

INSERT INTO users (username, password, role)
VALUES
(
    'admin',
    'admin',
    'ADMIN'
);