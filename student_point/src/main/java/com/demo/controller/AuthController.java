package com.demo.controller;

import com.demo.dto.request.LoginReq;
import com.demo.dto.request.SignupReq;
import com.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody @Valid LoginReq loginReq) {
        return ResponseEntity.ok(authService.authenticate(loginReq));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid SignupReq signupReq) {
        return ResponseEntity.ok(authService.createAccount(signupReq));
    }
}
