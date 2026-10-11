package com.example.backend.filter;

import com.example.backend.service.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtFilter implements Filter {

    private final JwtService jwtService;

    public JwtFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        final String path =httpRequest.getRequestURI();

        if (path.equals("/auth/login") ||
                path.equals("/auth/register") ||
                path.startsWith("/books")
        ) {
            chain.doFilter(request, response);
            return;
        }

        // xử lý token
        String authHeader = httpRequest.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            httpResponse.setStatus(401);
            return;
        }

        String token = authHeader.substring(7);

        try {
            Claims claims = jwtService.validateToken(token);

            String username = claims.get("username", String.class);
            String role = claims.get("role", String.class);

            request.setAttribute("username", username);
            request.setAttribute("role", role);

            chain.doFilter(request, response);

        } catch (Exception e) {
            httpResponse.setStatus(401);
        }
    }
}
