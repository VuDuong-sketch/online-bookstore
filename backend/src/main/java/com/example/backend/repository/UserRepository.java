package com.example.backend.repository;

import com.example.backend.entity.User;
import com.example.backend.enums.RegisterResult;
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
                        rs.getLong("id"),
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

        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    (rs, rowNum) -> new User(
                            rs.getLong("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("role")
                    ),
                    username
            );
        } catch (Exception e) {
            return null;
        }
    }

    public RegisterResult saveUser(User user) {

        String sql = """
                INSERT INTO users(username, password, role)
                VALUES (?, ?, ?)
                """;

        try {
            final int rows = jdbcTemplate.update(
                    sql,
                    user.getUsername(),
                    user.getPassword(),
                    user.getRole()
            );
        } catch (Exception e) {
            return RegisterResult.USERNAME_EXISTS;
        }

        return RegisterResult.SUCCESS;
    }
}
