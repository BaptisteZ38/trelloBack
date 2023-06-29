package com.example.backTrelloBis.controller;

import com.example.backTrelloBis.util.response.form.AuthenticationRequest;
import com.example.backTrelloBis.exception.UserResourceException;
import com.example.backTrelloBis.service.AuthService;
import com.example.backTrelloBis.util.response.AuthResponse;
import com.example.backTrelloBis.util.response.form.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {

        if (authenticationRequest.containsNullEntry()) {
            throw new UserResourceException("BadRequest", "Set email and password for login", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().body(this.authService.login(authenticationRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest) {

        if (registerRequest.containsNullEntry()) {
            throw new UserResourceException("BadRequest", "Set name, lastname, pseudo, email and password for register",
                    HttpStatus.BAD_REQUEST);
        }

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/auth/register").toUriString());

        return ResponseEntity.created(uri).body(this.authService.register(registerRequest));
    }

}
