package com.tourism.Travel_Buddy.repository;

import com.tourism.Travel_Buddy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,String> {

    //User findById(String email);

    @Override
    Optional<User> findById(String s);


    User findByEmail(String email);
}
