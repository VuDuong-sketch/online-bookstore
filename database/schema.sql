CREATE DATABASE bookstore;

USE bookstore;

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE books (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    author VARCHAR(255) NOT NULL,
    cover VARCHAR(255),
    price INT NOT NULL,
    stock INT NOT NULL,
    
    CHECK (price >= 0),
    CHECK (stock >= 0)
);

CREATE TABLE orders (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    total_amount INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    shipping_address VARCHAR(255) NOT NULL,
    shipping_phone VARCHAR(20) NOT NULL,
    
    FOREIGN KEY (user_id) REFERENCES users(id),
    CHECK (total_amount >= 0)
);

CREATE TABLE order_items (
	order_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    unit_price INT NOT NULL,
    
    PRIMARY KEY (order_id, book_id),
    
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (book_id) REFERENCES books(id),
    
    CHECK (quantity > 0),
    CHECK (unit_price >= 0)
);