package com.example.backTrelloBis.service;

import com.example.backTrelloBis.entity.Task;
import com.example.backTrelloBis.entity.User;
import com.example.backTrelloBis.repository.UserRepository;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Iterable<User> getAllUser(){return userRepository.findAll();}

    public Optional<User> getUserById(final ObjectId id_user){return userRepository.findById(id_user);}

    public void deleteUser(final ObjectId id_user){
        userRepository.deleteById(id_user);
    }

}
