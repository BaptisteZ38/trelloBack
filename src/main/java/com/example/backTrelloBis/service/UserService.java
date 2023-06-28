package com.example.backTrelloBis.service;

import com.example.backTrelloBis.entity.Task;
import com.example.backTrelloBis.entity.User;
import com.example.backTrelloBis.repository.UserRepository;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public User saveUser(User user){return userRepository.save(user);}

    public UserDetails findUserByEmail(String email) {
        User user = (User) userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Pas d'utilisateur trouvé"));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER")); // Ajoutez les rôles nécessaires ici

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    public void deleteUser(final ObjectId id_user){
        userRepository.deleteById(id_user);
    }

}
