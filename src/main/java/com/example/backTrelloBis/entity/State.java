package com.example.backTrelloBis.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("state")
public class State {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String state;
    public State(ObjectId id ,String state) {
        this.id = id;
        this.state = state;
    }
}
