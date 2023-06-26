package com.example.backTrelloBis.repository;

import com.example.backTrelloBis.entity.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends MongoRepository<Task, ObjectId> {
    Iterable<Task> findByIdUser(ObjectId idUser);

    Optional<Task> findByTask(String task);

    Iterable<Task> findByIdState(ObjectId idState);
}
