package com.example.backend.repository;

import com.example.backend.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooks() {

        final String sql = "SELECT * FROM books";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("author"),
                        rs.getString("cover"),
                        rs.getInt("price"),
                        rs.getInt("stock")
                )
        );
    }

    public Book getBookById(int id) {
        final String sql = "SELECT * FROM books WHERE id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("author"),
                        rs.getString("cover"),
                        rs.getInt("price"),
                        rs.getInt("stock")
                ),
                id
        );
    }

    public void saveBook(Book book) {

        final String sql = """
                UPDATE books SET
                title = ?,
                description = ?,
                author = ?,
                cover = ?,
                price = ?,
                stock = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(
                sql,
                book.getTitle(),
                book.getDescription(),
                book.getAuthor(),
                book.getCover(),
                book.getPrice(),
                book.getStock(),
                book.getId()
        );
    }
}
