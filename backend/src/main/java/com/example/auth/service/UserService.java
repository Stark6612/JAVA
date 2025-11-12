package com.example.auth.service;

import com.example.auth.dto.LoginRequest;
import com.example.auth.dto.RegisterRequest;
import com.example.auth.entity.User;
import com.example.auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User register(RegisterRequest req) {
        if (repo.existsByEmail(req.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }
        String encoded = passwordEncoder.encode(req.getPassword());
        User u = new User(req.getName(), req.getEmail(), encoded);
        return repo.save(u);
    }

    @Transactional(readOnly = true)
    public Optional<User> login(LoginRequest req) {
        return repo.findByEmail(req.getEmail())
                   .filter(u -> passwordEncoder.matches(req.getPassword(), u.getPassword()));
    }

    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String email) {
        return repo.findByEmail(email);
    }
}
