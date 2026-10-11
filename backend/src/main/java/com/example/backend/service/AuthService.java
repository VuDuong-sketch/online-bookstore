package com.example.backend.service;

import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password, String role) {

        if (username.isBlank() || password.isBlank() || role.isBlank()) {
            return false;
        }

        try {
            final User user = userRepository.findByUsername(username);

            return password.equals(user.getPassword()) && role.equals(user.getRole());

        } catch (Exception e) {
            return false;
        }
    }

    public void register(String username, String password) {

        userRepository.createUser(new User(0, username, password, "USER"));
    }
}
