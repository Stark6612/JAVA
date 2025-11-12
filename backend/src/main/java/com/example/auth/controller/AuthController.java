package com.example.auth.controller;

import com.example.auth.dto.LoginRequest;
import com.example.auth.dto.RegisterRequest;
import com.example.auth.entity.User;
import com.example.auth.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) { this.userService = userService; }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest req) {
        try {
            User saved = userService.register(req);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new SimpleResponse("registered", saved.getId(), saved.getEmail(), saved.getName()));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse("email_taken", ex.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest req) {
        // Check if user exists
        Optional<User> userOpt = userService.findByEmail(req.getEmail());
        
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("user_not_found", "User not registered"));
        }
        
        // User exists, check password
        Optional<User> loginResult = userService.login(req);
        if (loginResult.isPresent()) {
            User u = loginResult.get();
            return ResponseEntity.ok(new SimpleResponse("success", u.getId(), u.getEmail(), u.getName()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse("wrong_password", "Wrong password"));
        }
    }

    // small DTOs for responses
    public static class SimpleResponse {
        private String status;
        private Long id;
        private String email;
        private String name;

        public SimpleResponse() {}

        public SimpleResponse(String status, Long id, String email, String name) {
            this.status = status;
            this.id = id;
            this.email = email;
            this.name = name;
        }

        public String getStatus() { return status; }
        public Long getId() { return id; }
        public String getEmail() { return email; }
        public String getName() { return name; }

        public void setStatus(String status) { this.status = status; }
        public void setId(Long id) { this.id = id; }
        public void setEmail(String email) { this.email = email; }
        public void setName(String name) { this.name = name; }
    }

    public static class ErrorResponse {
        private String code;
        private String message;

        public ErrorResponse() {}

        public ErrorResponse(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() { return code; }
        public String getMessage() { return message; }

        public void setCode(String code) { this.code = code; }
        public void setMessage(String message) { this.message = message; }
    }
}
