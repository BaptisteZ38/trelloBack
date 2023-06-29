package com.example.backTrelloBis.util.response.form;


import com.example.backTrelloBis.util.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    private String email;
    private String password;
    public boolean containsNullEntry() {
        return (email == null) || (password == null);
    }

}
