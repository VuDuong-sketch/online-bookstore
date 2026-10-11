package com.example.backend.repository;

import com.example.backend.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAllUsers() {

        String sql = """
                SELECT *
                FROM users
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                )
        );
    }

    public User findByUsername(String username) {

        String sql = """
                SELECT *
                FROM users
                WHERE username = ?
                """;

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                ),
                username
        );
    }

    public void createUser(User user) {

        String sql = """
                INSERT INTO users(username, password, role)
                VALUE (?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                user.getUsername(),
                user.getPassword(),
                user.getRole()
        );

        final int userId  = jdbcTemplate.queryForObject(
                "SELECT LAST_INSERT_ID()",
                (rs, rowNum) -> rs.getInt("LAST_INSERT_ID()")
        );

        user.setId(userId);
    }
}
