package com.trimblecars.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        log.info("Authenticating user: {}", credentials.get("username"));
        if ("admin".equals(credentials.get("username")) && "admin123".equals(credentials.get("password"))) {
            return ResponseEntity.ok("Auth Token Dummy-12345");
        }
        return ResponseEntity.status(401).body("Unauthorized");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> userInfo) {
        log.info("Registering user: {}", userInfo.get("username"));
        return ResponseEntity.ok("User registered successfully");
    }
}