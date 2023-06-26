package com.example.backTrelloBis.repository;

import com.example.backTrelloBis.entity.State;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends MongoRepository<State, ObjectId> {
}
