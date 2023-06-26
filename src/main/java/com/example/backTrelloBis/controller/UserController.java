package com.example.backTrelloBis.controller;

import com.example.backTrelloBis.entity.User;
import com.example.backTrelloBis.service.UserService;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.bson.types.ObjectId;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public Iterable<User> getAllUser(){return userService.getAllUser();}

    @GetMapping("/{id_user}")
    public Optional<User> getUserById(@PathVariable final ObjectId id_user){return userService.getUserById(id_user);}

    @DeleteMapping("/{id_user}")
    public void deleteUser(@PathVariable final ObjectId id_user){
        userService.deleteUser(id_user);
    }

}
