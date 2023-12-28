package com.tourism.Travel_Buddy.repository;

import com.tourism.Travel_Buddy.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Integer> {


    Admin findByEmail(String email);
}
