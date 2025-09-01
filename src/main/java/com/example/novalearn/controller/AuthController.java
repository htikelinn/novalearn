package com.example.novalearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.novalearn.auth.AuthService;
import com.example.novalearn.dto.LoginRequest;
import com.example.novalearn.dto.RegisterDto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register/{type}")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto,
    @PathVariable("type") String accountType) {
        String responseString = authService.register(registerDto, accountType);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseString);
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String responseString = authService.login(loginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(responseString);
    }

}
