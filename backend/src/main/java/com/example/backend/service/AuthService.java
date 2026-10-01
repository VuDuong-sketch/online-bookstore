package com.example.backend.service;

import com.example.backend.entity.User;
import com.example.backend.enums.RegisterResult;
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

        final User user = userRepository.findByUsername(username);

        return user != null &&
                password.equals(user.getPassword()) &&
                role.equals(user.getRole());
    }

    public RegisterResult register(String username, String password) {

        if (username.isBlank()) {
            return RegisterResult.INVALID_USERNAME;
        }

        if (password.isBlank()) {
            return RegisterResult.INVALID_PASSWORD;
        }

        return userRepository.saveUser(new User(null, username, password, "USER"));
    }
}
