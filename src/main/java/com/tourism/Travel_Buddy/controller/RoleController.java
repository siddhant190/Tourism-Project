package com.tourism.Travel_Buddy.controller;

import com.tourism.Travel_Buddy.model.Role;
import com.tourism.Travel_Buddy.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/createRole")
    public Role createRole(@RequestBody Role role){
       return roleService.createRole(role);
    }
}
