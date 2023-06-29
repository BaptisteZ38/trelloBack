package com.example.backTrelloBis.service;

import com.example.backTrelloBis.util.form.AuthenticationRequest;
import com.example.backTrelloBis.entity.User;
import com.example.backTrelloBis.exception.UserResourceException;
import com.example.backTrelloBis.util.response.AuthResponse;
import com.example.backTrelloBis.util.response.UserResponse;
import com.example.backTrelloBis.util.form.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import com.example.backTrelloBis.util.JwtUtils;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    private final JwtUtils jwtUtils;

    public AuthResponse login(AuthenticationRequest authenticationRequest) {
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(), authenticationRequest.getPassword()));

        } catch (InternalAuthenticationServiceException e) {
            throw new UserResourceException("UserNotFound", "User Not Found", HttpStatus.NOT_FOUND);
        } catch (AuthenticationException e) {
            throw new UserResourceException("BadCredentials", "Bad Credential", HttpStatus.UNAUTHORIZED);
        }
        final User user = this.userService.getUserByEmail(authenticationRequest.getEmail());
        final UserResponse userResponse = new UserResponse(user.getId(), user.getNom(), user.getPrenom(), user.getEmail(), user.getPseudo(), user.getRole());
        String token = this.jwtUtils.generateToken(user);
        return new AuthResponse(userResponse, token);
    }


    public AuthResponse register(RegisterRequest registerRequest) {

        User user = this.userService.createUser(registerRequest);

        UserResponse userResponse = new UserResponse(user.getId(), user.getNom(), user.getPrenom(), user.getEmail(), user.getPseudo(), user.getRole());
        String token = this.jwtUtils.generateToken(user);

        return new AuthResponse(userResponse, token);
    }
}
