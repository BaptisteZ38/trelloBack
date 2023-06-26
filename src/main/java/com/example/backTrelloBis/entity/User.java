package com.example.backTrelloBis.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("user")
public class User {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String nom;
    private String prenom;
    public User(ObjectId id,String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }
}
