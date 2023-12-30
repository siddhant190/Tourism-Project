package com.tourism.Travel_Buddy.config;

import com.tourism.Travel_Buddy.model.Admin;
import com.tourism.Travel_Buddy.model.User;
import com.tourism.Travel_Buddy.repository.AdminRepo;
import com.tourism.Travel_Buddy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

     @Autowired
     private AdminRepo adminRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = repo.findByEmail(username);
       Admin admin = adminRepo.findByEmail(username);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority("USER"))
            );
         }
        if (admin != null) {
             return new org.springframework.security.core.userdetails.User(
                     admin.getEmail(),
                     admin.getPassword(),
                     Collections.singleton(new SimpleGrantedAuthority("ADMIN"))
             );
         } else {
            throw new UsernameNotFoundException("user not found with username: " + username);
        }
    }


}
