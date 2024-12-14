package com.serhii.practice.controller;


import com.serhii.practice.dto.LoginDTO;
import com.serhii.practice.dto.TokenDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO) {
        if (adminUsername.equals(loginDTO.getUsername()) && adminPassword.equals(loginDTO.getPassword())) {
            long expirationTime = System.currentTimeMillis() + 500 * 60 * 1000;
            String token = Base64.getEncoder().encodeToString((loginDTO.getUsername() + ":" + expirationTime).getBytes());

            TokenDTO tokenDTO = new TokenDTO(token);
            return ResponseEntity.ok(tokenDTO);

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Дані не правильні");
    }

    @GetMapping("/admin")
    public String showAdminPage(@RequestHeader(value = "Authorization", required = false) String authorizationHeader, Model model) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            if (isValidToken(token)) {
                return "admin";
            }
        }
        model.addAttribute("error", "Unauthorized: Invalid token or missing token");
        return "login";
    }

    private boolean isValidToken(String token) {
        try {
            String decodedToken = new String(Base64.getDecoder().decode(token));
            String[] parts = decodedToken.split(":");
            String username = parts[0];
            long expirationTime = Long.parseLong(parts[1]);

            return "admin".equals(username) && System.currentTimeMillis() <= expirationTime;
        } catch (Exception e) {
            return false;
        }
    }
}
