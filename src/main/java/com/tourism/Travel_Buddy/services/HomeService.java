package com.tourism.Travel_Buddy.services;

import com.tourism.Travel_Buddy.model.Status;
import com.tourism.Travel_Buddy.model.User;
import com.tourism.Travel_Buddy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class HomeService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Status login(User user) {
        System.out.println(user);
        User user2 = userRepo.findByEmail(user.getEmail());
        System.out.println(user2);
        if (user != null && user2 != null && passwordEncoder.matches(user.getPassword(), user2.getPassword())) {
            return new Status(true);
        } else {
            return new Status(false);
        }
    }
}
