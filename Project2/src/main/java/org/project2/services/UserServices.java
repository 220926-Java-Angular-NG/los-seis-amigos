package org.project2.services;

import org.project2.model.User;
import org.project2.repo.UserRepo;


public class UserServices {

    private UserRepo userRepo;

    public UserServices(){
        userRepo = new UserRepo();
    }

    public User getById(int id){
        return userRepo.getId(id);
    }

    public int createUser(User user){
        return userRepo.create(user);
    }

    public User updateUser(User user){
        return userRepo.update(user);
    }

    public User getByLogin(User user){
        return userRepo.loginUser(user);
    }

}
