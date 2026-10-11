package com.example.backend.repository;

import com.example.backend.entity.OrderItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public OrderItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createOrderItem(OrderItem orderItem) {

        final String sql = """
                INSERT INTO order_items (order_id, book_id, quantity, unit_price)
                VALUE (?, ?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                orderItem.getOrderId(),
                orderItem.getBookId(),
                orderItem.getQuantity(),
                orderItem.getUnitPrice()
        );
    }
}
