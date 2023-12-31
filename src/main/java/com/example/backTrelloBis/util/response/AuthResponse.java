package com.example.backTrelloBis.util.response;

import com.example.backTrelloBis.util.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private UserResponse user;
    private String token;

}
