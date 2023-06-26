package com.example.backTrelloBis.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.List;

@Data
@Document("task")
public class Task {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String task;
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId idUser;
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId idState;
}
