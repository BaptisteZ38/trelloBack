package com.example.backTrelloBis.controller;

import com.example.backTrelloBis.entity.User;
import com.example.backTrelloBis.service.UserService;
import com.example.backTrelloBis.util.form.RegisterRequest;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import javax.annotation.security.RolesAllowed;
import java.util.Optional;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RolesAllowed("USER")
    @GetMapping()
    public Iterable<User> getAllUser(){return userService.getAllUser();}
    @RolesAllowed("USER")
    @GetMapping("/{id_user}")
    public Optional<User> getUserById(@PathVariable final ObjectId id_user){return userService.getUserById(id_user);}
    @RolesAllowed("USER")
    @PostMapping("")
    public User createUser(@RequestBody RegisterRequest registerRequest){return userService.createUser(registerRequest);}
    @RolesAllowed("USER")
    @DeleteMapping("/{id_user}")
    public void deleteUser(@PathVariable final ObjectId id_user){
        userService.deleteUser(id_user);
    }

    @RolesAllowed("USER")
    @PutMapping("/{id_user}")
    public User updateUser(@PathVariable final ObjectId id_user, @RequestBody User user){
        Optional<User> userToUpdate = userService.getUserById(id_user);
        if(userToUpdate.isPresent()){
            User currentUser = userToUpdate.get();
            String nom = user.getNom();
            String prenom = user.getPrenom();
            String pseudo = user.getPseudo();

            if(nom != null){
                currentUser.setNom(nom);
            }
            if(prenom != null){
                currentUser.setPrenom(prenom);
            }
            if(pseudo != null){
                currentUser.setPseudo(pseudo);
            }
            userService.saveUser(currentUser);
            return currentUser;
        }else {
            return null;
        }
    }

}
