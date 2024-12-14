package com.serhii.practice.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class AdminAuthFilter extends OncePerRequestFilter {

    @Value("${admin.username}")
    private String adminUsername;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String path = request.getRequestURI();

        if (path.startsWith("/admin")) {
            String authHeader = request.getHeader("Authorization");

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Unauthorized: Token is missing or incorrect format");
                return;
            }

            try {
                String token = authHeader.substring(7);
                String decodedToken = new String(Base64.getDecoder().decode(token));
                String[] parts = decodedToken.split(":");
                String username = parts[0];
                long expirationTime = Long.parseLong(parts[1]);

                if (!adminUsername.equals(username) || System.currentTimeMillis() > expirationTime) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("Unauthorized: Invalid or expired token");
                    return;
                }
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Unauthorized: Malformed token");
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}
