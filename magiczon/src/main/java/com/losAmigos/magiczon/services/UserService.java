package com.losAmigos.magiczon.services;

import com.losAmigos.magiczon.models.User;
import com.losAmigos.magiczon.repos.UserRepository;
import com.losAmigos.magiczon.util.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User userLogin(User user){
        String username = user.getUsername();
        User loginUser = getByUsername(username);
        if(userRepository.existsByUsername(username)){
            if(user.getPassword().equals(loginUser.getPassword())) return loginUser;
        }
        return null;
    }

    public User registerUser(User user){
        String username = user.getUsername();
        if(userRepository.existsByUsername(username)){
            return null;
        }

        return createUser(user);
    }

    private User createUser(User user){
        return userRepository.save(user);
    }

    public User getById(Long id){

        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    private User getByUsername(String username){


        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
    }

    public User updatePassword(Long userId, String password) {
        User user = getById(userId);
        if (user == null) return null;
        user.setPassword(password);
        return userRepository.save(user);
    }

//    private User getById(Long userId){
//        return userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
//    }







}
