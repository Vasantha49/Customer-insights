package com.bank.customer_insights.controller;

import com.bank.customer_insights.dto.AuthDto;
import com.bank.customer_insights.dto.LoginRequestDto;
import com.bank.customer_insights.dto.RegisterDto;
import com.bank.customer_insights.model.User;
import com.bank.customer_insights.repositories.UserRepository;
import com.bank.customer_insights.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody RegisterDto request) {
        System.out.println("It reached here");
        User user = new User();
        user.setUsername(request.username);
        user.setPassword(passwordEncoder.encode(request.password));
        user.setEmail(request.email);// encode!
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public AuthDto login(@RequestBody LoginRequestDto request) {
        User user = userRepository.findByUsername(request.username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthDto(token);
    }
}
