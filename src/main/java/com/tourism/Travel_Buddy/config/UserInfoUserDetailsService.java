package com.tourism.Travel_Buddy.config;

import com.tourism.Travel_Buddy.model.Role;
import com.tourism.Travel_Buddy.model.User;
import com.tourism.Travel_Buddy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

//     @Autowired
//     private AdminRepo adminRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = repo.findByEmail(username);
       //Admin admin = adminRepo.findByEmail(username);
        if (user != null) {

            Set<GrantedAuthority> authorities = new HashSet<>();
            for (Role role : user.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }

            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    authorities
            );
         }
          else {
            throw new UsernameNotFoundException("user not found with username: " + username);
        }
    }


}
