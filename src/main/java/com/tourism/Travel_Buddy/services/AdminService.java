package com.tourism.Travel_Buddy.services;

import com.tourism.Travel_Buddy.model.Admin;
import com.tourism.Travel_Buddy.model.User;
import com.tourism.Travel_Buddy.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Admin registerAdmin(Admin admin) {
        admin.setRole("ADMIN");
        admin.setEmail("siddhant@gmail.com");
        admin.setName("siddhant");
        admin.setPassword(passwordEncoder.encode("sid19"));
        admin.setRole("ADMIN");
        return adminRepo.save(admin);
    }


}
