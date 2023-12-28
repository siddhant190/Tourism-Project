package com.tourism.Travel_Buddy.services;

import com.tourism.Travel_Buddy.model.User;
import com.tourism.Travel_Buddy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User registerUser(User user) {
        return userRepo.save(user);
    }

    public User getUser(int id) {
        return userRepo.findById(id);
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    public User updateUser(User user, int id) {
        User existingUser = userRepo.findById(id);
        existingUser.setId(id);
        existingUser.setName(user.getName());
        existingUser.setAddress(user.getAddress());
        existingUser.setMobile(user.getMobile());
        existingUser.setEmail(user.getEmail());
        User updatedProduct = userRepo.save(existingUser);
        return updatedProduct;
    }
}
