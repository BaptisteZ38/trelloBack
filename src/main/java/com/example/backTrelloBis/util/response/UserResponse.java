package com.example.backTrelloBis.util.response;

import com.example.backTrelloBis.config.Role;
import com.example.backTrelloBis.entity.User;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserResponse {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String nom;
    private String prenom;
    private String email;
    private String pseudo;
    private Role role;

    public UserResponse(User user) {
        this.id = user.getId();
        this.nom = user.getNom();
        this.prenom = user.getPrenom();
        this.email = user.getEmail();
        this.pseudo = user.getPseudo();
        this.role = user.getRole();
    }
}
