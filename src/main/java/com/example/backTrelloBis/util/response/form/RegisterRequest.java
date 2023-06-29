package com.example.backTrelloBis.util.response.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String nom;
    private String prenom;
    private String email;
    private String pseudo;
    private String password;

    public boolean containsNullEntry() {
        return (nom == null) || (prenom == null) || (email == null) || (pseudo == null) || (password == null);
    }
}
