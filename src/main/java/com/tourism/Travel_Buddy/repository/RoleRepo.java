package com.tourism.Travel_Buddy.repository;

import com.tourism.Travel_Buddy.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo  extends JpaRepository<Role,String> {
}
