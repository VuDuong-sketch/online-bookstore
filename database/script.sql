drop database bookstore;
create database bookstore;

use bookstore;

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

create table books (
	id bigint primary key auto_increment,
    title varchar(255) not null,
    description text,
    author varchar(255) not null,
    cover varchar(255),
    price int not null,
    stock int not null,
    
    check (price >= 0),
    check (stock >= 0)
);

create table orders (
	id bigint primary key auto_increment,
    user_id bigint not null,
    total_amount int not null,
    status varchar(20) not null,
    shipping_address varchar(255) not null,
    shipping_phone varchar(20) not null,
    
    foreign key (user_id) references users(id),
    check (total_amount >= 0)
);

create table order_items (
	order_id bigint not null,
    book_id bigint not null,
    quantity int not null,
    unit_price int not null,
    
    primary key (order_id, book_id),
    
    foreign key (order_id) references orders(id),
    foreign key (book_id) references books(id),
    
    check (quantity > 0),
    check (unit_price >= 0)
);