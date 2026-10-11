package com.example.backend.controller;

import com.example.backend.dto.auth.*;
import com.example.backend.service.AuthService;
import com.example.backend.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;

    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(
            @RequestBody LoginRequest loginRequest
            ) {

        final String username = loginRequest.getUsername();
        final String password = loginRequest.getPassword();
        final String role = loginRequest.getRole();

        if (username == null || password == null || role == null) { // body không chứa username hoặc password
            return ResponseEntity.status(400).build();
        }

        if (username.isBlank() || password.isBlank()) { // username hoac password = ""
            return ResponseEntity.status(400).build();
        }

        final boolean success = authService.login(username, password, role);

        if (success) {
            return ResponseEntity.status(200).body(
                    new LoginResponse(jwtService.generateToken( // Đăng nhập thành công trả về token
                            username,
                            role
                    ))
            );
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(
            @RequestBody RegisterRequest registerRequest
            ) {

        final String username = registerRequest.getUsername();
        final String password = registerRequest.getPassword();

        if (username == null || password == null) { // body không chứa username hoặc password
            return ResponseEntity.status(400).build();
        }

        if (username.isBlank() || password.isBlank()) { // username hoac password = ""
            return ResponseEntity.status(400).build();
        }

        try {
            authService.register(username, password);
        } catch (Exception e) {
            return ResponseEntity.status(409).build();
        }

        return ResponseEntity.status(201).build();
    }
}
