package com.example.backend.repository;

import com.example.backend.entity.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createOrder(Order order) {

        final String sql = """
                INSERT INTO orders (user_id, total_amount, status, shipping_address, shipping_phone)
                VALUE (?, ?, ?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                order.getUserId(),
                order.getTotalAmount(),
                order.getStatus(),
                order.getShippingAddress(),
                order.getShippingPhone()
        );

        final int orderId  = jdbcTemplate.queryForObject(
                "SELECT LAST_INSERT_ID()",
                (rs, rowNum) -> rs.getInt("LAST_INSERT_ID()")
        );

        order.setId(orderId);
    }

    public void saveOrder(Order order) {

        final String sql = """
                UPDATE orders SET
                total_amount = ?,
                status = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(
                sql,
                order.getTotalAmount(),
                order.getStatus(),
                order.getId()
        );
    }
}
