package com.example.backTrelloBis.util.response;

import com.example.backTrelloBis.entity.User;
import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserResponse {

    private ObjectId id;
    private String nom;
    private String prenom;
    private String email;
    private String pseudo;

    public UserResponse(User user) {
        this.id = user.getId();
        this.nom = user.getNom();
        this.prenom = user.getPrenom();
        this.email = user.getEmail();
        this.pseudo = user.getPseudo();
    }
}
