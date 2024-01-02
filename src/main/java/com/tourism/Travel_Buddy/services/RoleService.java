package com.tourism.Travel_Buddy.services;

import com.tourism.Travel_Buddy.model.Role;
import com.tourism.Travel_Buddy.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;
    public Role createRole(Role role) {
        return roleRepo.save(role);
    }
}
