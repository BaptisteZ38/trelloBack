package com.example.backTrelloBis.service;

import com.example.backTrelloBis.config.Role;
import com.example.backTrelloBis.entity.User;
import com.example.backTrelloBis.exception.UserResourceException;
import com.example.backTrelloBis.repository.UserRepository;
import com.example.backTrelloBis.util.form.RegisterRequest;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Data
@Service
public class UserService {

    private final UserRepository userRepository;

    public Iterable<User> getAllUser(){return userRepository.findAll();}

    public Optional<User> getUserById(final ObjectId id_user){return userRepository.findById(id_user);}

    public User createUser(RegisterRequest registerRequest){
        User user = new User(null, registerRequest.getNom(), registerRequest.getPrenom(), registerRequest.getEmail(), registerRequest.getPseudo(), registerRequest.getPassword(), Role.ROLE_USER);
        try {
            return this.userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new UserResourceException("UserAlreadyExists", "The user " + user.getEmail() + " already exists.",
                    HttpStatus.CONFLICT);
        } catch (Exception e) {
            throw new UserResourceException("CreateUserError", "Error while creating the user: " + user.getEmail(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public User getUserByEmail(String email) {
        Optional<User> user = this.userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserResourceException("UserNotFound", "Username not found in database", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteUser(final ObjectId id_user){
        userRepository.deleteById(id_user);
    }

    public User saveUser(final User user){
        return userRepository.save(user);
    }

}
