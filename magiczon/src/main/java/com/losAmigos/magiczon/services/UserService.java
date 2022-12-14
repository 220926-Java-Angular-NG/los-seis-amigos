package com.losAmigos.magiczon.services;

import com.losAmigos.magiczon.models.ChangePassword;
import com.losAmigos.magiczon.models.User;
import com.losAmigos.magiczon.repos.UserRepository;
import com.losAmigos.magiczon.util.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User userLogin(User user) {
        String username = user.getUsername();
        User loginUser = getByUsername(username);
        if (userRepository.existsByUsername(username)) {
            if (user.getPassword().equals(loginUser.getPassword())) {
                return loginUser;
            } else {
                User passwordMissMatch = new User();
                passwordMissMatch.setUsername("PASSWORDMISSMATCH");
                return passwordMissMatch;
            }
        } else {
            User userNameMissMatch = new User();
            userNameMissMatch.setUsername("USERNAMEMISSMATCH");
            System.out.println("USERNAME MISS MATCH");
            return userNameMissMatch;
        }
    }

    public User registerUser(User user) {
        String username = user.getUsername();
        if (userRepository.existsByUsername(username)) {
            return null;
        }

        return createUser(user);
    }

    private User createUser(User user) {
        return userRepository.save(user);
    }

    public User getById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    private User getByUsername(String username) {


        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
    }

    public User updatePassword(ChangePassword user) {
        String password = user.getNewPassword();
        User newUser = new User();
        newUser.setPassword(user.getPassword());
        newUser.setUsername(user.getUsername());
        newUser = userLogin(newUser);
        if (newUser == null || password == null) return null;
        newUser.setPassword(password);
        return userRepository.save(newUser);
    }

//    private User getById(Long userId){
//        return userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
//    }


}
