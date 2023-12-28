package com.tourism.Travel_Buddy.repository;

import com.tourism.Travel_Buddy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,Integer> {

    User findById(int id);

    User findByEmail(String email);
}
