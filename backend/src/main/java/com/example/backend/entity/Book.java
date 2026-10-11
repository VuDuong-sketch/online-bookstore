package com.example.backend.entity;

public class Book {

    private int id;
    private String title;
    private String description;
    private String author;
    private String cover;
    private int price;
    private int stock;

    public Book() {
    }

    public Book(
            int id,
            String title,
            String description,
            String author,
            String cover,
            int price,
            int stock
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.cover = cover;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
